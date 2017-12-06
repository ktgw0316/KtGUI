package io.github.mslxl.ktswing

import java.awt.*
import javax.swing.JComponent
import javax.swing.JFrame

inline fun JComponent.bounds(code:Rectangle.()->Unit){
    this.bounds = this.bounds.apply(code)
}


inline fun JComponent.size(code:Dimension.()->Unit){
    this.size = this.size.apply(code)
}

inline fun JComponent.maxSize(code: Dimension.() -> Unit){
    this.maximumSize = this.maximumSize.apply(code)
}

inline fun JComponent.minSize(code: Dimension.() -> Unit){
    this.minimumSize = this.minimumSize.apply(code)
}

fun <T> Component.findComponentByName(name:String):T?{
    var root = this
    while (root.parent!=null){
        root = root.parent
    }
    val comp = when(root){
        is KtSwingFrame->root.cache[name]
        is KtSwingDialog->root.cache[name]
        else -> null
    }

    fun find(container: Container):Component?{
        val comps = container.components
        for (it in comps) {
            if (it.name == name){
                return it
            } else if (it is Container){
                val result = find(it)
                if(result != null){
                    return result
                }
            }
        }
        return null
    }

    return if (comp != null) comp as T else (find(root as Container))?.apply {
        when(root){
            is KtSwingDialog->root.cache[name] = this
            is KtSwingFrame->root.cache[name] = this

        }
    } as T

}