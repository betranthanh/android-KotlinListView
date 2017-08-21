package bett.com.kotlinlistview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import bett.com.kotlinlistview.adapters.UserListAdapter
import bett.com.kotlinlistview.dtos.UserDto

class MainActivity: AppCompatActivity() {

    var listView: ListView? = null
    var adapter: UserListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById<ListView>(R.id.listView)
        adapter = UserListAdapter(this, generateData())

        listView?.adapter = adapter
        adapter?.notifyDataSetChanged()

    }

    fun generateData(): ArrayList<UserDto> {
        var result = ArrayList<UserDto>()

        for (i in 0..9) {
            var user: UserDto = UserDto("Bett", "Awesome work ;)")
            result.add(user)
        }

        return result
    }
}
