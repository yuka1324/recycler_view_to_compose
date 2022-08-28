package com.example.myapplication.compose

import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myapplication.Item

@Composable
fun itemsList(item: Item) {
    ConstraintLayout(Modifier.height(height = 100.dp)) {
        val (id, name) = createRefs()
        Text(
            text = item.id,
            modifier = Modifier.constrainAs(id) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(name.start)
            },
            fontSize = 20.sp
        )
        Text(
            text = item.name,
            modifier = Modifier.constrainAs(name) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(id.end)
                end.linkTo(parent.end)
            },
            fontSize = 20.sp
        )
        createHorizontalChain(id, name, chainStyle = ChainStyle.Spread)
        Divider(color = Color(0x44666666))
    }
}

@Preview
@Composable
fun PreviewGreeting() = itemsList(item = createDummyDataList()[0])