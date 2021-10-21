import javafx.application.Application
import javafx.application.Platform
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.input.KeyCode
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.stage.Stage
import java.awt.event.KeyEvent
import java.beans.EventHandler
import java.util.*

class Main() : Application() {
    var pause = false
    override fun start(stage: Stage?) {
        val model = Model()

        // our layout is the root of the scene graph
        val root = VBox()

        val layout = BorderPane()

        // views are the children of the top-level layout
        val toolbar = ToolbarView(model)
        val gridView = GridView(model)
        val status = StatusView(model)

        // register views with the model
        model.addView(toolbar)
        model.addView(gridView)
        model.addView(status)

        var timer = Timer()

        timer.schedule(object: TimerTask() {
            override fun run() {
                Platform.runLater {
                    model.IncrementFrame()
                    model.AfterFrame()
                }
            }

        }, 0, 1000)

        root.setOnKeyPressed { event ->
            if(event.code == KeyCode.P) {
                pause = true
                timer.cancel()
            } else if(event.code == KeyCode.N) {
                if(pause) {
                    model.IncrementFrame()
                    model.AfterFrame()
                }

            } else if(event.code == KeyCode.R) {
                pause = false
                timer = Timer()

                timer.schedule(object: TimerTask() {
                    override fun run() {
                        Platform.runLater {
                            model.IncrementFrame()
                            model.AfterFrame()
                        }
                    }

                }, 0, 1000)

            }
        }

        // setup and display

        root.children.addAll(toolbar, gridView, status) // gridView






        stage?.scene = Scene(root)
        stage?.isResizable = false
        stage?.width = 990.0
        stage?.height = 755.0
        stage?.title = "Conway's Game of Life (z263zhu)"
        stage?.show()
    }
}