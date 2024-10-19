package com.example.agoraapitest.model

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.example.agoraapitest.R
import com.example.agoraapitest.samples.ChannelEncryption
import com.example.agoraapitest.samples.CustomAudioRender
import com.example.agoraapitest.samples.CustomAudioSource
import com.example.agoraapitest.samples.CustomVideoRender
import com.example.agoraapitest.samples.CustomVideoSource
import com.example.agoraapitest.samples.HostAcrossChannel
import com.example.agoraapitest.samples.JoinChannelAudio
import com.example.agoraapitest.samples.JoinChannelVideo
import com.example.agoraapitest.samples.JoinChannelVideoToken
import com.example.agoraapitest.samples.JoinMultiChannel
import com.example.agoraapitest.samples.LiveStreaming
import com.example.agoraapitest.samples.LocalVideoTranscoding
import com.example.agoraapitest.samples.MediaMetadata
import com.example.agoraapitest.samples.MediaPlayer
import com.example.agoraapitest.samples.MediaRecorder
import com.example.agoraapitest.samples.OriginAudioData
import com.example.agoraapitest.samples.OriginVideoData
import com.example.agoraapitest.samples.PictureInPictureEntrance
import com.example.agoraapitest.samples.PlayAudioFiles
import com.example.agoraapitest.samples.PreCallTest
import com.example.agoraapitest.samples.RTMPStreaming
import com.example.agoraapitest.samples.RhythmPlayer
import com.example.agoraapitest.samples.ScreenSharing
import com.example.agoraapitest.samples.SendDataStream
import com.example.agoraapitest.samples.SpatialSound
import com.example.agoraapitest.samples.VideoProcessExtension
import com.example.agoraapitest.samples.VoiceEffects

data class Example(
    @StringRes val name: Int,
    val description: String = "",
    val content: @Composable (back: () -> Unit) -> Unit
)

val BasicExampleList = listOf(
    Example(R.string.example_join_channel_video_token) { JoinChannelVideoToken() },
    Example(R.string.example_join_channel_video) { JoinChannelVideo() },
    Example(R.string.example_join_channel_audio) { JoinChannelAudio() }
)

val AdvanceExampleList = listOf(
    Example(R.string.example_live_streaming) { LiveStreaming() },
    Example(R.string.example_rtmp_streaming) { RTMPStreaming() },
    Example(R.string.example_media_metadata) { MediaMetadata() },
    Example(R.string.example_voice_effects) { VoiceEffects() },
    Example(R.string.example_originaudiodata) { OriginAudioData() },
    Example(R.string.example_customaudiosource) { CustomAudioSource() },
    Example(R.string.example_customaudiorender) { CustomAudioRender() },
    Example(R.string.example_originvideodata) { OriginVideoData() },
    Example(R.string.example_customvideosource) { CustomVideoSource() },
    Example(R.string.example_customvideorender) { CustomVideoRender() },
    Example(R.string.example_pictureinpicture) { PictureInPictureEntrance(it) },
    Example(R.string.example_joinmultichannel) { JoinMultiChannel() },
    Example(R.string.example_channelencryption) { ChannelEncryption() },
    Example(R.string.example_playaudiofiles) { PlayAudioFiles() },
    Example(R.string.example_precalltest) { PreCallTest() },
    Example(R.string.example_mediarecorder) { MediaRecorder() },
    Example(R.string.example_mediaplayer) { MediaPlayer() },
    Example(R.string.example_screensharing) { ScreenSharing() },
    Example(R.string.example_videoprocessextension) { VideoProcessExtension() },
    Example(R.string.example_rhythmplayer) { RhythmPlayer() },
    Example(R.string.example_localvideotranscoding) { LocalVideoTranscoding() },
    Example(R.string.example_senddatastream) { SendDataStream() },
    Example(R.string.example_hostacrosschannel) { HostAcrossChannel() },
    Example(R.string.example_spatialsound) { SpatialSound() },
)