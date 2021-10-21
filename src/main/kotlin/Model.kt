class Model {
    var lastShape = ""
    var lastx = -1
    var lasty = -1
    var frame = 0


    fun listenerShape(shape: String) {
        lastShape = shape

    }

    fun addShape(receiver: String, i:Int, j:Int) {
        if(receiver == "block") { // block button
            board[i][j] = true
            board[i + 1][j] = true
            board[i][j + 1] = true
            board[i + 1][j + 1] = true
        } else if(receiver == "beehive") {
            board[i + 1][j] = true
            board[i + 2][j] = true
            board[i][j + 1] = true
            board[i + 3][j + 1] = true
            board[i + 1][j + 2] = true
            board[i + 2][j + 2] = true
        } else if(receiver == "blinker") {
            board[i][j + 1] = true
            board[i + 1][j + 1] = true
            board[i + 2][j + 1] = true
        } else if(receiver == "toad") {
            board[i + 1][j] = true
            board[i + 2][j] = true
            board[i + 3][j] = true
            board[i][j + 1] = true
            board[i + 1][j + 1] = true
            board[i + 2][j + 1] = true

        } else if(receiver == "glider") {
            board[i][j + 1] = true
            board[i + 2][j] = true
            board[i + 2][j + 1] = true
            board[i + 2][j + 2] = true
            board[i + 1][j + 2] = true

        }
        lastx = i
        lasty = j
        notifyViews()
    }


    val Boolean.int
        get() = if (this) 1 else 0

    fun AfterFrame() {
        var alive_cells = 0
        val copyboard =  Array(sizeInner + 5) { BooleanArray(sizeOuter + 5) }
        for(j in 0..49) {
            for(i in 0..74) {
                copyboard[i][j] = board[i][j]
            }
        }

        for (j in 0..49) {
            for (i in 0..74) {
                if(i == 0 && j == 0) { // top left corner
                    alive_cells = copyboard[i + 1][j].int + copyboard[i][j + 1].int +
                            copyboard[i + 1][j + 1].int
                    if(alive_cells < 2 && copyboard[i][j]) {
                        board[i][j] = false
                    } else if(alive_cells > 3 && copyboard[i][j]) {
                        board[i][j] = false
                    } else if(alive_cells == 3 && !copyboard[i][j]) {
                        board[i][j] = true

                    }
                } else if(i == 0 && j == 49) { //  bottom left corner
                    alive_cells = copyboard[i][j - 1].int + copyboard[i + 1][j - 1].int +
                            copyboard[i + 1][j].int
                    if(alive_cells < 2 && copyboard[i][j]) {
                        board[i][j] = false
                    } else if(alive_cells > 3 && copyboard[i][j]) {
                        board[i][j] = false
                    } else if(alive_cells == 3 && !copyboard[i][j]) {
                        board[i][j] = true
                    }
                } else if(i == 74 && j == 0) { // top right corner
                    alive_cells = copyboard[i - 1][j].int + copyboard[i - 1][j + 1].int +
                            copyboard[i][j + 1].int
                    if(alive_cells < 2 && copyboard[i][j]) {
                        board[i][j] = false
                    } else if(alive_cells > 3 && copyboard[i][j]) {
                        board[i][j] = false
                    } else if(alive_cells == 3 && !copyboard[i][j]) {
                        board[i][j] = true
                    }
                } else if(i == 74 && j == 49) { // bottom right corner
                    alive_cells = copyboard[i - 1][j].int + copyboard[i - 1][j - 1].int +
                            copyboard[i][j - 1].int
                    if(alive_cells < 2 && copyboard[i][j]) {
                        board[i][j] = false
                    } else if(alive_cells > 3 && copyboard[i][j]) {
                        board[i][j] = false
                    } else if(alive_cells == 3 && !copyboard[i][j]) {
                        board[i][j] = true
                    }
                } else if(i == 0) { // on the left side

                    alive_cells = copyboard[i][j - 1].int + copyboard[i][j + 1].int +
                            copyboard[i + 1][j - 1].int + copyboard[i + 1][j].int +
                            copyboard[i + 1][j + 1].int
                    if(alive_cells < 2 && copyboard[i][j]) {
                        board[i][j] = false
                    } else if(alive_cells > 3 && copyboard[i][j]) {
                        board[i][j] = false
                    } else if(alive_cells == 3 && !copyboard[i][j]) {
                        board[i][j] = true
                    }
                } else if(i == 74) { // on the right side
                    alive_cells = copyboard[i][j - 1].int + copyboard[i][j + 1].int +
                            copyboard[i - 1][j - 1].int + copyboard[i - 1][j].int +
                            copyboard[i - 1][j + 1].int
                    if(alive_cells < 2 && copyboard[i][j]) {
                        board[i][j] = false
                    } else if(alive_cells > 3 && copyboard[i][j]) {
                        board[i][j] = false
                    } else if(alive_cells == 3 && !copyboard[i][j]) {
                        board[i][j] = true
                    }
                } else if(j == 0) { // on the top side
                    alive_cells = copyboard[i - 1][j].int + copyboard[i + 1][j].int +
                            copyboard[i - 1][j + 1].int + copyboard[i][j + 1].int +
                            copyboard[i + 1][j + 1].int

                    if(alive_cells < 2 && copyboard[i][j]) {
                        board[i][j] = false
                    } else if(alive_cells > 3 && copyboard[i][j]) {
                        board[i][j] = false
                    } else if(alive_cells == 3 && !copyboard[i][j]) {

                        board[i][j] = true
                        println(board[i][j])
                        println(copyboard[i][j])
                    }
                } else if(j == 49) { // on the bottom side
                    alive_cells = copyboard[i - 1][j].int + copyboard[i + 1][j].int +
                            copyboard[i - 1][j - 1].int + copyboard[i][j - 1].int +
                            copyboard[i + 1][j - 1].int
                    if(alive_cells < 2 && copyboard[i][j]) {
                        board[i][j] = false
                    } else if(alive_cells > 3 && copyboard[i][j]) {
                        board[i][j] = false
                    } else if(alive_cells == 3 && !copyboard[i][j]) {
                        board[i][j] = true
                    }
                } else {
                    alive_cells = copyboard[i - 1][j - 1].int + copyboard[i][j - 1].int +
                            copyboard[i + 1][j - 1].int + copyboard[i - 1][j].int +
                            copyboard[i + 1][j].int + copyboard[i - 1][j + 1].int +
                            copyboard[i][j + 1].int + copyboard[i + 1][j + 1].int
                    if(alive_cells < 2 && copyboard[i][j]) {
                        board[i][j] = false
                    } else if(alive_cells > 3 && copyboard[i][j]) {
                        board[i][j] = false
                    } else if(alive_cells == 3 && !copyboard[i][j]) {
                        board[i][j] = true
                    }
                }
            }
        }
        notifyViews()
    }



    // represent my board
    private val sizeOuter = 50
    private val sizeInner = 75

    private val views = ArrayList<IView>()
    val board = Array(sizeInner + 5) { BooleanArray(sizeOuter + 5) }


    // board manipulation

    // (b) clear the board

    // view management
    fun addView(view: IView) {
        views.add(view)
    }

    fun removeView(view: IView) {
        views.remove(view)
    }

    fun notifyViews() {
        for (view in views) {
            view.update()
        }
    }

    fun IncrementFrame() {
        frame++
        this.notifyViews()
    }
}