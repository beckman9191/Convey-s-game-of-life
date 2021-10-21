import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.Priority
import javafx.scene.layout.Region

class StatusView(private val model: Model) : IView, HBox() {
    var shape_label = Label("hi")
    var frame_label = Label(model.frame.toString())

    init {
        var spacer = Pane()

        HBox.setHgrow(spacer, Priority.ALWAYS)

        this.children.addAll(shape_label, spacer, frame_label)





    }

    override fun update() {
        // react to updates from model
        // how do we get data from the model? do we need it?
        var shape = model.lastShape
        var x = model.lastx
        var y = model.lasty
        var frame_counter = model.frame

        if(model.lastx == -1 && model.lasty == -1) {
            frame_label.text = "Frame: $frame_counter"
            shape_label.text = "Cleared"
        } else {
            frame_label.text = "Frame: $frame_counter"
            shape_label.text = "Created $shape at $x, $y"
        }


    }
}