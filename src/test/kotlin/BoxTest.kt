import io.github.mslxl.ktgui.ktswing.component.*
import io.github.mslxl.ktgui.ktswing.frame
import io.github.mslxl.ktgui.ktswing.layout.borderpanel
import io.github.mslxl.ktgui.ktswing.layout.cardpanel
import javax.swing.WindowConstants

fun main() {
    frame {
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE

        cardpanel {
            borderpanel {
                north {
                    vBox {
                        vGlue()
                        label("One")
                        vStrut(10)
                        label("Two")
                    }
                }
                south {
                    hBox {
                        hGlue()
                        button("Cancel")
                        hStrut(5)
                        button("OK")
                        hStrut(5)
                    }
                }
            }
        }
    }
}