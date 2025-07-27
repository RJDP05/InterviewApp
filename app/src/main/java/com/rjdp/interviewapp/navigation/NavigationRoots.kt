package com.rjdp.interviewapp.navigation

import kotlinx.serialization.Serializable


sealed interface SubRoot{

    @Serializable
    data object Auth : SubRoot

    @Serializable
    data object Home : SubRoot

}

sealed interface AuthRoot {

    @Serializable
    data object WelcomeScreen : AuthRoot

    @Serializable
    data object SignUpScreen : AuthRoot

    @Serializable
    data object LogInScreen : AuthRoot

    @Serializable
    data object ForgotPasswordScreen : AuthRoot

}

sealed interface HomeRoot {

    @Serializable
    data object HomeScreen : HomeRoot

    @Serializable
    data object ProfileScreen : HomeRoot

    @Serializable
    data object SettingsScreen : HomeRoot

    @Serializable
    data object InterviewScreen : HomeRoot

}

//@Serializable
//sealed interface SettingsRoots {
//
//    @Serializable
//    data object Settings : SettingsRoots
//
//    @Serializable
//    data object ChangePassword : SettingsRoots
//
//    @Serializable
//    data object ChangePhoneNumber : SettingsRoots
//
//    @Serializable
//    data object DeleteAccount : SettingsRoots
//
//}

//@Serializable
//sealed interface InterviewRoots {
//
//    @Serializable
//    data object Interview : InterviewRoots
//
//    @Serializable
//    data object CreateInterview : InterviewRoots
//
//    @Serializable
//    data object EditInterview : InterviewRoots
//
//    @Serializable
//    data object ViewInterview : InterviewRoots
//}
//
//@Serializable
//sealed interface ProfileRoots {
//
//    @Serializable
//    data object Profile : ProfileRoots
//
//    @Serializable
//    data object EditProfile : ProfileRoots
//
//    @Serializable
//    data object ViewProfile : ProfileRoots
//
//    @Serializable
//    data object ChangePassword : ProfileRoots
//
//}
