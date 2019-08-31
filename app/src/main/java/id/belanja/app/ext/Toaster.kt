package id.belanja.app.ext

import android.content.Context
import android.widget.Toast

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Aug, Sat 31 2019 13:02
 **/
fun Any.toast(context: Context, duration: Int = Toast.LENGTH_SHORT): Toast {
    return Toast.makeText(context, this.toString(), duration).apply { show() }
}