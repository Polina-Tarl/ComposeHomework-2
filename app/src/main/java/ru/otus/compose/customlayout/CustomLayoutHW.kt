package ru.otus.compose.customlayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Task: Make custom grid layout
 */
@Composable
fun CustomLayoutHW(
    columns: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        val placeables = measurables.map { it.measure(constraints) }

        val columnCount = if (columns < 1) 1 else columns
        val rowCount = (measurables.size / columnCount) + 1

        val columnWidths = IntArray(columnCount)
        val rowHeights = IntArray(rowCount)

        placeables.forEachIndexed { index, placeable ->
            val column = index % columnCount
            val row = index / columnCount
            columnWidths[column] = maxOf(columnWidths[column], placeable.width)
            rowHeights[row] = maxOf(rowHeights[row], placeable.height)
        }

        val width = columnWidths.sum().coerceIn(constraints.minWidth, constraints.maxWidth)
        val height = rowHeights.sum().coerceIn(constraints.minHeight, constraints.maxHeight)

        layout(width, height) {
            val columnX = IntArray(columnCount)
            for (i in 1 until columnCount) {
                columnX[i] = columnX[i - 1] + columnWidths[i - 1]
            }

            val rowY = IntArray(rowCount)
            for (i in 1 until rowCount) {
                rowY[i] = rowY[i - 1] + rowHeights[i - 1]
            }

            placeables.forEachIndexed { index, placeable ->
                val column = index % columnCount
                val row = index / columnCount
                placeable.placeRelative(x = columnX[column], y = rowY[row])
            }
        }
    }
}


@Preview
@Composable
fun CustomLayoutHWPreview() {
    Surface {
        CustomLayoutHW(
            columns = 3,
            modifier = Modifier
                .padding(4.dp)
                .border(2.dp, color = Color.Black)
                .padding(4.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.catanddot),
                contentDescription = null,
                Modifier
                    .size(100.dp)
                    .padding(4.dp)
                    .border(2.dp, color = Color.Black)
            )
            Image(
                painter = painterResource(id = R.drawable.catanddot),
                contentDescription = null,
                Modifier
                    .size(110.dp)
                    .padding(4.dp)
                    .border(2.dp, color = Color.Black)
            )
            Image(
                painter = painterResource(id = R.drawable.catanddot),
                contentDescription = null,
                Modifier
                    .size(90.dp)
                    .padding(4.dp)
                    .border(2.dp, color = Color.Black)
            )
            Image(
                painter = painterResource(id = R.drawable.catanddot),
                contentDescription = null,
                Modifier
                    .size(120.dp)
                    .padding(4.dp)
                    .border(2.dp, color = Color.Black)
            )
            Image(
                painter = painterResource(id = R.drawable.catanddot),
                contentDescription = null,
                Modifier
                    .size(100.dp)
                    .padding(4.dp)
                    .border(2.dp, color = Color.Black)
            )
            Image(
                painter = painterResource(id = R.drawable.catanddot),
                contentDescription = null,
                Modifier
                    .size(80.dp)
                    .padding(4.dp)
                    .border(2.dp, color = Color.Black)
            )
            Image(
                painter = painterResource(id = R.drawable.catanddot),
                contentDescription = null,
                Modifier
                    .size(100.dp)
                    .padding(4.dp)
                    .border(2.dp, color = Color.Black)
            )
            Image(
                painter = painterResource(id = R.drawable.catanddot),
                contentDescription = null,
                Modifier
                    .size(120.dp)
                    .padding(4.dp)
                    .border(2.dp, color = Color.Black)
            )
            Image(
                painter = painterResource(id = R.drawable.catanddot),
                contentDescription = null,
                Modifier
                    .size(100.dp)
                    .padding(4.dp)
                    .border(2.dp, color = Color.Black)
            )
            Image(
                painter = painterResource(id = R.drawable.catanddot),
                contentDescription = null,
                Modifier
                    .size(90.dp)
                    .padding(4.dp)
                    .border(2.dp, color = Color.Black)
            )
        }
    }
}