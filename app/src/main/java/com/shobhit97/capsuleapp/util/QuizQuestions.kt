package com.shobhit97.capsuleapp.util

import com.shobhit97.capsuleapp.domain.model.Question

val questions =  listOf(
    Question(
        "What does SDK stand for in Android development?",
        listOf("Software Development Kit", "System Design Kernel", "Secure Development Kit", "Systematic Deployment Kernel"),
        0
    ),
    Question(
        "Which file is responsible for defining the structure of an Android app's user interface?",
        listOf("AndroidManifest.xml", "layout.xml", "UIConfig.xml", "main.xml"),
        1
    ),
    Question(
        "What is the purpose of an Intent in Android?",
        listOf("To navigate between activities", "To store data in the database", "To define app permissions", "To manage background tasks"),
        0
    ),
    Question(
        "In Android, what is the role of the ViewGroup?",
        listOf("Store data locally", "Define the app's permissions", "Manage user input", "Organize and control the layout of child views"),
        3
    ),
    Question(
        "Which lifecycle method is called when an activity is no longer visible to the user?",
        listOf("onResume()", "onStop()", "onDestroy()", "onPaused()"),
        1
    ),
    Question(
        "What is the primary purpose of the RecyclerView in Android?",
        listOf("Displaying a single item", "Handling user gestures", "Efficiently displaying lists of data", "Managing network requests"),
        2
    ),
    Question(
        "Which layout manager is used to arrange views in a grid in Android?",
        listOf("LinearLayoutManager", "GridLayout", "FrameLayout", "RelativeLayout"),
        1
    ),
    Question(
        "What is the function of the AsyncTask class in Android?",
        listOf("Handle UI updates", "Perform background tasks", "Manage database operations", "Handle user input events"),
        1
    ),
    Question(
        "Which component is used for background processing in Android?",
        listOf("Service", "BroadcastReceiver", "ContentProvider", "Activity"),
        0
    ),
    Question(
        "What is the significance of the AndroidX library in modern Android development?",
        listOf("Backward compatibility", "Testing Android apps", "UI design", "Database management"),
        0
    )
)