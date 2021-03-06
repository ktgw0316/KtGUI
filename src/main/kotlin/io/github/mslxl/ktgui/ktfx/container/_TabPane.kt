@file:JvmName("Container")
@file:JvmMultifileClass
package io.github.mslxl.ktgui.ktfx.container


import io.github.mslxl.ktgui.ktfx.FxPanelNode
import io.github.mslxl.ktgui.ktfx.FxPanelNodePanel
import io.github.mslxl.ktgui.ktfx._ktfx
import io.github.mslxl.ktgui.ktfx._ktfxInit
import javafx.scene.Node
import javafx.scene.control.Tab
import javafx.scene.control.TabPane

class _TabPane : TabPane(){
    inline fun tab(title: String = "", block: _Tab.() -> Unit) {
        _Tab(title)._ktfxInit().apply(block).let {
            tabs.add(it)
        }
    }
    class _Tab(text: String): Tab(text),FxPanelNode{
        override fun _onAddToContent(comp: Node) {
            content = comp._ktfxInit()
        }
    }
}

inline fun FxPanelNodePanel.tabPane(block:_TabPane.()->Unit) = _ktfx(_TabPane(),block)
