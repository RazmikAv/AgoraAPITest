package com.example.agoraapitest.ui.widget

@Compose
fun APIListItem (text: String, action: Unit) {
    // Unit callback must be given.
    // Show text as a description.
    // Invoke action when it's clicked.
    Card (
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        elevation = CardDefaults.elecardElevation(5.dp)
    ) {
        Text(text)
    }
}

@Preview
@Compose
fun APIListItemPreview() {
    APIListItem(text = "Simple API test.") {
        Log.i("TEST", "Item was clicked.")
    }
}