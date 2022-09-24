package com.orlandev.jetpackcomposetest.tests

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode

/*
  Testing Nested Scroll between two components that have the same scroll direction

https://medium.com/bazaar-tech/nested-lazyverticalgrid-with-jetpack-compose-f50d1a8f7e6e
 */

@Composable
fun TestNestedLazyScroll() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            for (i in 1..10) {
                Text(text = "Text $i", modifier = Modifier.padding(10.dp))
            }
        }
        item {
            val itemSize: Dp = (LocalConfiguration.current.screenWidthDp.dp / 2)
            FlowRow(
                mainAxisSize = SizeMode.Expand,
                mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween
            ) {
                for (i in 1..10) {
                    Text(
                        text = "Text $i",
                        modifier = Modifier.size(itemSize),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
