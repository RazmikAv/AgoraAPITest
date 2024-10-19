package com.example.agoraapitest.ui.widget

@Composable
fun ChannelNameInput(
    modifier: Modifier = Modifier,
    channelName: String,
    isJoined: Boolean,
    onJoinClick: (String) -> Unit = {_ -> },
    onLeaveClick: () -> Unit = {}
) {
    var text by remeberSaveable {
        mutableStateOf(channelName)
    }
    InputRaw(
        modifier = modifier,
        text = text,
        btnText = if (isJoined) stringResource(R.string.leave) else stringResource(R.string.join),
        label = stringResource(R.string.channel_name)
    ) {
        text = it
        if (isJoined) onLeaveClick() else onJoinClick(it)
    }
}

@Composable
fun VideoGrid(
    modifier: Modifier = Modifier,
    raw: Int = 2,
    column: Int = 2,
    videoIdList: List<Int>,
    setupVideo: (View, Int, Boolean) -> Unit,
    statsMap: Map<Int, VideoStatsInfo> = emptyMap(),
    overlay: @Composable BoxScope.(index: Int, id: Int) -> Unit? = {_, _ -> }
) {
    Column(modifier) {
        for (rawIndex in 0..<raw) {
            Row(Modifier.weight(1.0f)) {
                for (columnIndex in 0..<column) {
                    Box(modifier = Modifier.weight(1.0f)) {
                        val index = rawIndex * column + columnIndex
                        videoIdList.getOrNull(index)?.let {
                            id ->
                            VideoCell(
                                id = id,
                                isLocal = index == 0,
                                setupVideo = setupVideo,
                                statsInfo = statsMap[id],
                                overlay = { overlay(index, id)}
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun VideoCell(
    modifier: Modifier = Modifier,
    id: Int,
    isLocal: Boolean,
    isSelected: Boolean = false,
    isWindowMode: Boolean = false,
    createView: ((context: Context) -> View)? = null,
    setupVideo: (renderView: View, id: Int, isFirstSetup: Boolean) -> Unit,
    statsInfo: VideoStatsInfo? = null,
    overlay: @Composable BoxScope.() -> Unit? = {}
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(5.dp),
        border = BorderStroke(
            width = 2.dp, color = if(!isSelected) {
                Color.Gray
            } else {
                Color.Blue
            }
        )
    ) {
        Box(modifier) {
            if (isWindowMode || !isSelected) {
                AndroidView(
                    factory = { context ->
                        createView?.invoke(context) ?: TextureView(context).apply {
                            tag = id
                            setupVideo(this, id, true)
                        }
                    },
                    update = { view ->
                        if(view.tag != id) {
                            view.tag = id
                            setupVideo(view, id, false)
                        }
                    }
                )
            } else {
                Spacer(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

//@Compose
//fun VideoCell(uid: Int, status: ParticipantStatus) {
//    // Draw card layout.
//    Card(
//        modifier = Modifier.weight(1),
//        elevation = CardDefaults.cardElevation(5.dp)
//    ) {
//        Text(status.name)
//        // Now it' time to add Texture view.
//        AndroidView(LocalContext.current) {
//            TextureView()
//        }
//    }
//}

data class ParticipantStatus (
    val uid: Int,
    val name: String,
    var selected: Boolean,
    var isSpeaking: Boolean,
    var hasCamera: Boolean,
    val isAudience: Boolean
)