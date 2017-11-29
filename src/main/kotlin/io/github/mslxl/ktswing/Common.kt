package io.github.mslxl.ktswing

import java.awt.Component
import java.awt.Container
import javax.swing.JComponent
import javax.swing.JFrame

interface Content {
    fun onAddToContent(comp: Component)
}

inline fun <E : JComponent> __ktswing(comp: E, parent: Content, init: E.() -> Unit): E {
    parent.onAddToContent(comp)
    init.invoke(comp)
    comp.repaint()
    comp.validate()
    comp.updateUI()
    return comp
}

fun __ktswingPanelAdd(panel: BasePanel, container: Container) {
    if (container is JFrame) {
        container.contentPane = panel
    } else if (container is Content){
        (container as Content).onAddToContent(panel)
    } else {
        container.add(panel)
    }
}

inline fun <F : BasePanel> __ktswingPanel(panel: F, container: Container, init: F.() -> Unit): BasePanel {
    __ktswingPanelAdd(panel, container)
    init.invoke(panel)
    return panel
}

fun _createContent(onAdd: (comp: Component) -> Unit): Content {
    return object : Content {
        override fun onAddToContent(comp: Component){
            onAdd.invoke(comp)
        }
    }
}
