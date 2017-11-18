import io.github.mslxl.ktswing.*
import io.github.mslxl.ktswing.event.addWindowListener
import io.github.mslxl.ktswing.event.onActionPerformed
import javax.swing.JOptionPane
import javax.swing.JTextField

fun main(args: Array<String>) {
    frame(title = "Test1") {
        size {
            height = 500
            width = 600
        }

        addWindowListener {
            onActivated {
                println("Activated")
            }
        }

        isResizable = false
        exitOnClose

        menubar {
            menu("hello") {
                menuItem("world") {
                    onActionPerformed {
                        JOptionPane.showMessageDialog(this@frame, "hello,world")
                    }
                }
            }
        }

        absolutepanel {
            at {
                label("KtSwing") {
                    bounds {
                        x = 20
                        y = 20
                        width = 560
                        height = 30
                    }
                }
            }
            at {
                borderpanel {
                    bounds {
                        x = 20
                        y = 60
                        width = 560
                        height = 430
                    }
                    north {
                        flowpanel {
                            textfield("hello,world") {
                                name = "text"
                            }
                            button("Click Me") {
                                onActionPerformed {
                                    JOptionPane.showMessageDialog(this, findComponentByName<JTextField>("text")!!.text)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}