package baz.bar.foo.myapplication

import android.app.Application
import android.graphics.Color
import com.instabug.bug.BugReporting
import com.instabug.chat.Chats
import com.instabug.chat.Replies
import com.instabug.crash.CrashReporting
import com.instabug.library.Feature
import com.instabug.library.Instabug
import com.instabug.library.InstabugCustomTextPlaceHolder
import com.instabug.library.invocation.InstabugInvocationEvent
import com.instabug.library.ui.onboarding.WelcomeMessage
import java.util.Locale

class InstabugConfiguration {

    companion object {

        fun applyTo(application: Application) {
            Instabug.Builder(application, /* token here*/)
                .setInvocationEvents(InstabugInvocationEvent.SHAKE)
                .build()

            Instabug.setLocale(Locale.GERMAN)
            CrashReporting.setState(Feature.State.DISABLED)
            Instabug.setWelcomeMessageState(WelcomeMessage.State.DISABLED)
            Chats.setState(Feature.State.DISABLED)
            Replies.setState(Feature.State.DISABLED)
            BugReporting.setShakingThreshold(900)

            BugReporting.setReportTypes(BugReporting.ReportType.BUG, BugReporting.ReportType.FEEDBACK)

            Instabug.setColorTheme(com.instabug.library.InstabugColorTheme.InstabugColorThemeDark)
            Instabug.setPrimaryColor(Color.WHITE)

            val textPlaceHolders = InstabugCustomTextPlaceHolder()
            textPlaceHolders.set(
                InstabugCustomTextPlaceHolder.Key.INVOCATION_HEADER,
                "Feedback senden"
            )

            textPlaceHolders.set(
                InstabugCustomTextPlaceHolder.Key.REPORT_BUG,
                "Foo bar"
            )

            textPlaceHolders.set(
                InstabugCustomTextPlaceHolder.Key.COMMENT_FIELD_HINT_FOR_BUG_REPORT,
                "Foo bar"
            )

            textPlaceHolders.set(
                InstabugCustomTextPlaceHolder.Key.REPORT_FEEDBACK,
                "Foo bar"
            )

            textPlaceHolders.set(
                InstabugCustomTextPlaceHolder.Key.COMMENT_FIELD_HINT_FOR_FEEDBACK,
                "Foo bar"
            )
            Instabug.setCustomTextPlaceHolders(textPlaceHolders)
        }
    }
}