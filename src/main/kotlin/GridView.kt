import javafx.scene.control.Button
import javafx.scene.control.ToolBar
import javafx.scene.layout.GridPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle


class GridView(private val model: Model) : IView, GridPane() {
    init {
        this.isGridLinesVisible = true
        this.hgap = 1.0
        this.vgap = 1.0

        for (i in 0..74) {
            for (j in 0..49) {
                val rect = Rectangle(12.0, 12.0)
                rect.fill = Color.WHITE
                rect.setOnMouseClicked {

                    model.addShape(model.lastShape, i, j)

                    // println("i is " + i.toString())
                    // println("j is " + j.toString())


                }
                this.add(rect, i, j)
            }
        }
    }

    override fun update() {

        for(child in this.children) {
            if(child is Rectangle) {
                val y = getColumnIndex(child)
                val x = getRowIndex(child)

                if(model.board[y][x] == true) {
                    child.fill = Color.BLACK
                } else {
                    child.fill = Color.WHITE
                }
            }
        }

    }
}