## Build ListView with Custom Adapter in Kotlin

## Video step by step
[![Watch the video](http://i.imgur.com/QBxc8b3l.png)](https://goo.gl/9ipBif)

### 1. Add listview
```java
var listView: ListView? = null
listView = findViewById<ListView>(R.id.listView)
```

### 2. Create your model
```java
class UserDto {
    var name: String = ""
    var comment: String = ""

    constructor() {}

    constructor(name: String, comment: String) {
        this.name = name
        this.comment = comment
    }
}
```
### 3. Create row layout
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical">

    <ImageView
        android:id="@+id/imgAvatar"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_margin="10dp"
        android:src="@drawable/avatar1" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_centerVertical="true"
        android:layout_toRightOf="@id/imgAvatar"
        android:orientation="vertical">

        <TextView
            android:id="@+id/txtName"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Name"
            android:textStyle="bold"
            />
        <TextView
            android:id="@+id/txtComment"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="comment"/>
    </LinearLayout>
</RelativeLayout>
```
### 4. Create adapter class
```java
class UserListAdapter(private var activity: Activity, private var items: ArrayList<UserDto>): BaseAdapter() {
    
    private class ViewHolder(row: View?) {
        var txtName: TextView? = null
        var txtComment: TextView? = null

        init {
            this.txtName = row?.findViewById<TextView>(R.id.txtName)
            this.txtComment = row?.findViewById<TextView>(R.id.txtComment)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View?
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.user_list_row, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var userDto = items[position]
        viewHolder.txtName?.text = userDto.name
        viewHolder.txtComment?.text = userDto.comment

        return view as View
    }

    override fun getItem(i: Int): UserDto {
        return items[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }
}
```

### 5. Combine all together
```java
adapter = UserListAdapter(this, generateData())

listView?.adapter = adapter
adapter?.notifyDataSetChanged()
....
fun generateData(): ArrayList<UserDto> {
    var result = ArrayList<UserDto>()

    for (i in 0..9) {
        var user: UserDto = UserDto("Bett", "Awesome work ;)")
        result.add(user)
    }

    return result
}
```

## Contact
Drop me an email if you want discuss anything further. [Email](betranthanh@gmail.com)

## License
Licensed under the MIT license.
