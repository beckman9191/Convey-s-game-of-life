import javafx.scene.control.Button
import javafx.scene.control.ToolBar
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import java.io.File
import java.io.FileInputStream

class ToolbarView(private val model: Model) : IView, ToolBar() {
    init {
        val blockButton = Button("Block")
        val beehiveButton = Button("Beehive")
        val blinkerButton = Button("Blinker")
        val toadButton = Button("Toad")
        val gliderButton = Button("glider")
        val clearButton = Button("clear")

        val path = File("${System.getProperty("user.dir")}/src/main/resources")

        // blockButton.graphic = ??
        blockButton.setOnAction { event ->
            model.listenerShape("block")
        }
        beehiveButton.setOnAction { event ->
            model.listenerShape("beehive")
        }
        blinkerButton.setOnAction { event ->
            model.listenerShape("blinker")
        }
        toadButton.setOnAction { event ->
            model.listenerShape("toad")
        }
        gliderButton.setOnAction { event ->
            model.listenerShape("glider")
        }

        clearButton.setOnAction { event ->
            for(i in 0..74) {
                for(j in 0..49) {
                    model.board[i][j] = false
                }
            }
            model.lastShape = ""
            model.lastx = -1
            model.lasty = -1
            model.notifyViews()
        }

        // add buttons to toolbar
        this.items.add(blockButton)
        val blockImg = ImageView(Image(FileInputStream(path.toString() + "/block.png")))
        blockImg.fitWidth = 30.0
        blockImg.fitHeight = 30.0
        blockButton.graphic = blockImg

        this.items.add(beehiveButton)
        val beehiveImg = ImageView(Image(FileInputStream(path.toString() + "/beehive.png")))
        beehiveImg.fitWidth = 30.0
        beehiveImg.fitHeight = 30.0
        beehiveButton.graphic = beehiveImg

        this.items.add(blinkerButton)
        val blinkerImg = ImageView(Image(FileInputStream(path.toString() + "/blinker.png")))
        blinkerImg.fitWidth = 30.0
        blinkerImg.fitHeight = 30.0
        blinkerButton.graphic = blinkerImg

        this.items.add(toadButton)
        val toadImg = ImageView(Image(FileInputStream(path.toString() + "/toad.png")))
        toadImg.fitWidth = 30.0
        toadImg.fitHeight = 30.0
        toadButton.graphic = toadImg

        this.items.add(gliderButton)
        val gliderImg = ImageView(Image(FileInputStream(path.toString() + "/glider.png")))
        gliderImg.fitWidth = 30.0
        gliderImg.fitHeight = 30.0
        gliderButton.graphic = gliderImg

        this.items.add(clearButton)
        val clearImg = ImageView(Image(FileInputStream(path.toString() + "/clear.png")))
        clearImg.fitWidth = 30.0
        clearImg.fitHeight = 30.0
        clearButton.graphic = clearImg


    }



    override fun update() {
        // update my button state
        // how do we get data from the model?
    }
}