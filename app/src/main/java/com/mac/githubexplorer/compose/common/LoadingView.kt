package com.mac.githubexplorer.compose.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.mac.githubexplorer.R

@Composable
internal fun LoadingView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.wrapContentSize(),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.ic_loading),
            contentDescription = stringResource(id = R.string.loading)
        )
        Text(text = stringResource(id = R.string.loading))
    }
}

@Composable
@Preview(
    device = Devices.PIXEL_4
)
internal fun LoadingViewPreview() {
    LoadingView(Modifier.fillMaxSize())
}