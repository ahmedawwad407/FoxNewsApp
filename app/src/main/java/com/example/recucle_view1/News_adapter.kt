package com.example.listveiw1

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recucle_view1.Details
import com.example.recucle_view1.R

class News_adapter : RecyclerView.Adapter<News_adapter.Recycl_holder> {
    var layoutid: Int = 0
    lateinit var datalist: ArrayList<News>
    lateinit var context: Context

    constructor(layoutid: Int, array: ArrayList<News>, context: Context) {
        this.layoutid = layoutid
        this.datalist = array
        this.context = context

    }


    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): Recycl_holder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(layoutid, parent, false)
        return Recycl_holder(view)
    }

    override fun onBindViewHolder(holder: Recycl_holder, position: Int) {
        holder.deletebtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val dialog = AlertDialog.Builder(context)//confirm
                dialog.setTitle("confirm Dialog")
                dialog.setMessage("Ary you want to delete ??")
                dialog.setIcon(R.drawable.ddd)
                dialog.setPositiveButton("OK", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        datalist.removeAt(position)//delet item list
                        notifyDataSetChanged()// update item list

                    }
                })
                dialog.setNegativeButton("cancel", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        if (dialog != null) {
                            dialog.dismiss()//hide dialog
                        }
                    }
                })
                dialog.setNeutralButton("Do nothing", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {

                    }
                })
                val AlertDialog = dialog.create()
                AlertDialog.setCanceledOnTouchOutside(false)//touch screen not hide dialog
                AlertDialog.show()

            }
        })
        val news = datalist.get(position)//return News

        holder.newsimagev.setImageResource(news.photo)
        holder.newsdate.setText(news.date)
        holder.newstext.setText(news.title)
    }

    inner class Recycl_holder : RecyclerView.ViewHolder {
        lateinit var newsimagev: ImageView
        lateinit var newstext: TextView
        lateinit var newsdate: TextView
        lateinit var deletebtn: ImageButton

        constructor(itemView: View) : super(itemView) {
            itemView.setOnClickListener {
                val news = datalist.get(adapterPosition)
                var i = Intent(context, Details::class.java)
                i.putExtra("desc", news.descreption)
                i.putExtra("link", news.link)
                i.putExtra("inPhoto", news.inPhoto)
                context.startActivity(i)
            }
            newsimagev = itemView.findViewById<ImageView>(R.id.imageView1)
            newstext = itemView.findViewById<TextView>(R.id.text)
            newsdate = itemView.findViewById<TextView>(R.id.date)
            deletebtn = itemView.findViewById<ImageButton>(R.id.imageButton1)
        }
    }
}

