package ru.skillbranch.devintensive.ui.profile


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



import ru.skillbranch.devintensive.R


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ProfileActivity : AppCompatActivity() {
    /*companion object {
        const val IS_EDIT_MODE = "IS_EDIT_MODE"
    }


    var isEditMode = false
    lateinit var viewFields: Map<String, TextView> */

    /**
     * Вызывается при первом создании или перезапуске Activity
     *
     * здесь задается внешний вид активности (UI) через метод setContentView().
     * инициализируются представления
     * представления связываются с необходимыми данными и ресурсами
     * связываются данные со списками
     *
     * Этот метод также предоставляет Bundle , содержащий ранее созраненное
     * состояние Activity, если оно было.
     *
     * Всегда сопровождается вызовом onStart().
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        //initViews(savedInstanceState)

    }

    /* private fun initViews(savedInstanceState: Bundle?) {
        viewFields = mapOf(
            "nickname" to tv_nick_name,
            "rank" to tv_rank,
            "firstName" to et_first_name,
            "lastName" to et_last_name,
            "about" to et_about,
            "repository" to et_repository,
            "rating" to tv_rating,
            "respect" to tv_respect
        )



        btn_edit.setOnClickListener(View.OnClickListener {
            isEditMode = !isEditMode
            showCurrentMode(isEditMode)
        })
    } */

   /* private fun showCurrentMode(editMode: Boolean) {

    } */


    /**
     * Этот метод сохраняет состояние представления в Bundle
     * Для API level < 28 этот метод будет выполняться до onStop() , и нет никаких гарантий относительно того,
     * произойдет ли это до или после onPause()
     * Для API level >= 28 будет вызван после onStop()
     * Не будет вызван, если Activity будет явно закрыто пользователем при нажатии на системную кнопку back
     */

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

    }

}
