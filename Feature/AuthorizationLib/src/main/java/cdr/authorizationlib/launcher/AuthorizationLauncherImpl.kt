package cdr.authorizationlib.launcher

import androidx.activity.ComponentActivity
import cdr.authorizationlib.presentation.PrimaryActivity

/**
 * Реализация [AuthorizationLauncher]
 *
 * @author Alexandr Chekunkov
 */
class AuthorizationLauncherImpl : AuthorizationLauncher {

    override fun launchAuthorizationScreen(
        activity: ComponentActivity,
        launchData: AuthorizationLaunchData
    ) {
        when (launchData) {
            AuthorizationLaunchData.PRIMARY -> activity.startActivity(PrimaryActivity.newIntent(activity))
        }
    }
}