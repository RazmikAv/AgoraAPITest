package com.example.agoraapitest

// App preview.
@Preivew(showBackground = true)
@Compose
fun AgoraTestAppPreview() {
    AgoraTestApp()
}

@Compose
fun AgoraTestApp() {
    NavGraph(nav)
}

@Compose
fun ApiList() {
    Scaffold (
        appBar = {

        }
    ) {
        Column {
            Text("Agora Video API Test")
            ApiItem("Video call with record test")
        }
    }
}