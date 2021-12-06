package hu.stewemetal.composedemo.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import hu.stewemetal.composedemo.R.drawable
import hu.stewemetal.composedemo.model.Item
import hu.stewemetal.composedemo.ui.theme.ComposeDemoTheme
import hu.stewemetal.composedemo.ui.theme.Grey

@Composable
fun ListItem(
    item: Item,
) {
    ConstraintLayout(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .height(60.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {

        val (text, chevron) = createRefs()

        Text(
            text = item.text,
            color = Grey,
            fontSize = 16.sp,
            modifier = Modifier
                .constrainAs(text) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(chevron.start)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                },
        )
        Icon(
            painterResource(id = drawable.ic_chevron_right),
            tint = Grey,
            contentDescription = "Item arrow forward",
            modifier = Modifier
                .constrainAs(chevron) {
                    top.linkTo(parent.top)
                    start.linkTo(text.end, margin = 16.dp)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.value(40.dp)
                    height = Dimension.value(40.dp)
                },
        ) // ...
    }
}

@Preview
@Composable
fun ListItemPreview() {
    ComposeDemoTheme {
        ListItem(Item(text = "Item 1"))
    }
}