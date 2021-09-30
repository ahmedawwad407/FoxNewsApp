package com.example.recucle_view1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listveiw1.News
import com.example.listveiw1.News_adapter
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.navigation.NavigationView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var toogle: ActionBarDrawerToggle

    var db = FirebaseFirestore.getInstance()

    lateinit var news1: News
    lateinit var news2: News
    lateinit var news3: News
    lateinit var news4: News
    lateinit var news5: News
    lateinit var news6: News
    lateinit var news7: News
    lateinit var news8: News
    lateinit var news9: News
    lateinit var news10: News
    lateinit var news11: News
    lateinit var news12: News

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val drawerlayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        toogle = ActionBarDrawerToggle(
            this,
            drawerlayout,
            toolbar,
            R.string.open,
            R.string.close
        )//connection toolbar and Drawer_layout
        toogle.syncState()//create icon borger
        drawerlayout.addDrawerListener(toogle)//change icon borger and icon close


        var navigationView = findViewById<NavigationView>(R.id.NavigationView)
        navigationView.setNavigationItemSelectedListener(object :
            NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item_menu: MenuItem): Boolean {
                if (item_menu.itemId == R.id.account) {

                    Toast.makeText(applicationContext, "account", Toast.LENGTH_LONG).show()
                    drawer_layout.closeDrawers()//close navigationDrawer
                } else if (item_menu.itemId == R.id.setting) {

                    Toast.makeText(applicationContext, "setting", Toast.LENGTH_LONG).show()
                    drawer_layout.closeDrawers()
                } else if (item_menu.itemId == R.id.contacts) {

                    Toast.makeText(applicationContext, "contacts", Toast.LENGTH_LONG).show()
                    drawer_layout.closeDrawers()
                } else if (item_menu.itemId == R.id.VideoScreen) {
                    val i = Intent(applicationContext, VideoOffLoading::class.java)
                    startActivity(i)
                    drawer_layout.closeDrawers()
                } else if (item_menu.itemId == R.id.AboutApp) {
                    val i = Intent(applicationContext, aboutScreen::class.java)
                    startActivity(i)
                    drawer_layout.closeDrawers()
                } else if (item_menu.itemId == R.id.ImageScreen) {
                    val i = Intent(applicationContext, ImagesOfNews::class.java)
                    startActivity(i)
                    drawer_layout.closeDrawers()
                }
                return true
            }
        })

        if (navigationView.headerCount > 0) {
            val view: View = navigationView.getHeaderView(0)
            var imageButton = view.findViewById<ImageButton>(R.id.imageButton)
            imageButton.setOnClickListener {
                finish()
            }
        }
        news1 = News()
        news1.photo = R.drawable.image01
        news1.inPhoto = R.drawable.image01
        news1.title = "هل تؤدي أحداث القدس إلى انتفاضة ثالثة؟"
        news1.date = "2021-05-08T14:53:12Z"
        news1.descreption =
            " أكثر من 200 فلسطيني في اشتباكات في القدس، ومغردون فلسطينيون وعرب يتحدثون عن انتفاضة ثالثة." + " \n " + " \n للمزيد من تفاصيل حول الخبر اذهب الى الموقع. "
        news1.link = "https://www.bbc.com/arabic/trending-57040495"

        news2 = News()
        news2.photo = R.drawable.image02
        news2.inPhoto = R.drawable.image02
        news2.title = " إصابة عشرات الفلسطينيين مع اندلاع مواجهات"
        news2.date = "2021-05-08T23:47:00Z"
        news2.descreption =
            "يأتي هذا بعد يوم من إصابة أكثر من 200 فلسطيني و6 ضباط إسرائيليين في بعض من أسوأ أعمال العنف في محيط المسجد الأقصى منذ سنوات." + " \n " + " \n للمزيد من تفاصيل حول الخبر اذهب الى الموقع. "
        news2.link = "https://www.bbc.com/arabic/middleeast-57034318"

        news3 = News()
        news3.photo = R.drawable.image03
        news3.inPhoto = R.drawable.image03
        news3.title =
            "الاتحاد الأوروبي: ندعو للتهدئة في القدس."
        news3.date = "2021-05-08T13:13:55Z"
        news3.descreption =
            "أصدرت مفوضية الاتحاد الأوروبي،" +
                    " بيانا السبت، يدين تصاعد العنف في الضفة الغربية المحتلة، خاصة في القدس الشرقية." + " \n " + " \n للمزيد من تفاصيل حول الخبر اذهب الى الموقع. "
        news3.link =
            "https://arabic.cnn.com/middle-east/article/2021/05/08/eu-calls-de-escalation-tensions-in-jerusalem"

        news4 = News()
        news4.photo = R.drawable.image04
        news4.inPhoto = R.drawable.image04
        news4.title = "روسيا تدين بشدة الإجراءات الإسرائيلية في القدس الشرقية"
        news4.date = "2021-05-08T15:19:30Z"
        news4.descreption = "أدانت روسيا بشدة الاعتداءات على المدنيين في القدس الشرقية، " +
                "ودعت جميع الأطراف إلى الامتناع عن أي خطوات محفوفة بتصعيد العنف،" +
                " بحسب بيان لوزارة الخارجية الروسية صدر السبت." + " \n " + " \n للمزيد من تفاصيل حول الخبر اذهب الى الموقع. "
        news4.link =
            "https://arabic.cnn.com/middle-east/article/2021/05/08/russia-strongly-condemns-violence-in-east-jerusalem"

        news5 = News()
        news5.photo = R.drawable.image05
        news5.inPhoto = R.drawable.image05
        news5.title = "القدس: 90 ألفًا في المسجد الأقصى ليلة القدر"
        news5.date = "2021-05-08T20:06:30Z"
        news5.descreption =
            "وصل عشرات الآلاف من الفلسطينيين إلى القدس، للمشاركة في لإحياء ليلة القدر" +
                    "، إحدى الليال المقدسة خلال شهر رمضان، فيما شهدت المدينة مناوشات " +
                    "واعتقالات من جانب الشرطة الإسرائيلية في منطقتي باب العمود وحي الشيخ جرّاح." + " \n " + " \n للمزيد من تفاصيل حول الخبر اذهب الى الموقع. "
        news5.link =
            "https://arabic.cnn.com/middle-east/article/2021/05/09/jerusalem-unrest-al-aqsa-mosque"

        news6 = News()
        news6.photo = R.drawable.image06
        news6.inPhoto = R.drawable.image06
        news6.title = "شارك في معركة القدس بجوار صلاح الدين."
        news6.date = "2021-05-08T22:10:28Z"
        news6.descreption = "لا تزال شوارع حي الشيخ جراح في مدينة القدس المحتلة،" +
                " تشهد اضطرابات ومواجهات عنيفة، في محاولة من المواطنيين الفلسطينيين منع إخلاء قسري وشيك لـ500 عائلة فلسطينية تسكن الحي، وتمكين مستوطنين إسرائيليين،" +
                " من منازلهم، بدعوى تنفيذ أحكام قضائية إسرائيلية تقتضي طرد العائلات" + " \n " + " \n للمزيد من تفاصيل حول الخبر اذهب الى الموقع. "
        news6.link = "https://www.sasapost.com/hussam-al-din-al-jarrahi/"

        news7 = News()
        news7.photo = R.drawable.image07
        news7.inPhoto = R.drawable.image07
        news7.title = "الولايات المتحدة تعبر عن قلقها من مواجهات القدس "
        news7.date = "2021-05-08T16:08:48Z"
        news7.descreption = "عبّرت الولايات المتحدة عن قلقها إزاء المواجهات الدائرة في القدس،" +
                " بما في ذلك الحرم القدسي الشريف وحي الشيخ جراح، التي أسفرت عن إصابة العشرات، مساء الجمعة." + " \n " + " \n للمزيد من تفاصيل حول الخبر اذهب الى الموقع. "

        news7.link =
            "https://arabic.cnn.com/middle-east/article/2021/05/08/us-expresses-its-concern-over-confrontations-in-jerusalem"

        news8 = News()
        news8.photo = R.drawable.image08
        news8.inPhoto = R.drawable.image08
        news8.title = "القدس: 90 ألفًا في المسجد الأقصى ليلة القدر."
        news8.date = "2021-05-08T20:06:30Z"
        news8.descreption =
            "وصل عشرات الآلاف من الفلسطينيين إلى القدس، للمشاركة في لإحياء ليلة القدر، " +
                    "إحدى الليال المقدسة خلال شهر رمضان،" +
                    " فيما شهدت المدينة مناوشات واعتقالات من جانب الشرطة الإسرائيلية في منطقتي باب العمود وحي الشيخ جرّاح." + " \n " + " \n للمزيد من تفاصيل حول الخبر اذهب الى الموقع. "
        news8.link =
            "https://arabic.cnn.com/middle-east/article/2021/05/09/jerusalem-unrest-al-aqsa-mosque"

        news9 = News()
        news9.photo = R.drawable.image09
        news9.inPhoto = R.drawable.image09
        news9.title = "الإمارات تدين اقتحام المسجد الأقصى وتهجير الفلسطينيين"
        news9.date = "2021-05-08T11:44:24Z"
        news9.descreption =
            "أعربت الإمارات عن إدانتها لاقتحام المسجد الأقصى وإخلائه من المصلين وتهجير الفلسطينيين من بيوتهم في حي الشيخ جراح في القدس،" +
                    " ودعت إسرائيل إلى خفض التصعيد، وفق ما ذكرته وكالة أنباء الإمارات الرسمية (وام)" + " \n " + " \n للمزيد من تفاصيل حول الخبر اذهب الى الموقع. "
        news9.link =
            "https://arabic.cnn.com/middle-east/article/2021/05/08/uae-condemns-aqsa-invasion-shaikh-jarrah"

        news10 = News()
        news10.photo = R.drawable.image10
        news10.inPhoto = R.drawable.image10
        news10.title = "السعودية تعلن موقفها من الإجراءات الإسرائيلية في القدس"
        news10.date = "2021-05-08T07:44:02Z"
        news10.descreption =
            "أكدت السعودية رفضها للإجراءات الإسرائيلية بإخلاء منازل في القدس وفرض السيطرة الإسرائيلية عليها، في إشارة غير مباشرة إلى أحداث حي الشيخ جراح." + " \n " + " \n للمزيد من تفاصيل حول الخبر اذهب الى الموقع. "
        news10.link =
            "https://arabic.cnn.com/middle-east/article/2021/05/08/saudi-condemnation-israel-measures-jerusalem"

        news11 = News()
        news11.photo = R.drawable.image12
        news11.inPhoto = R.drawable.image12
        news11.title = " إليك كل ما تحتاج معرفته عن التوترات الأخيرة"
        news11.date = "2021-05-08T18:52:31Z"
        news11.descreption =
            "أصيب ما لا يقل عن 205 أشخاص في المسجد الأقصى بالقدس بعد أن اشتبكت شرطة مكافحة الشغب الإسرائيلية " +
                    "مع فلسطينيين بعد صلاة العشاء، بحسب الهلال الأحمر الفلسطيني." + " \n " + " \n للمزيد من تفاصيل حول الخبر اذهب الى الموقع. "
        news11.link =
            "https://arabic.cnn.com/middle-east/video/2021/05/08/v105705-jerusalem-israeli-police-palestinians-al-aqsa-mosque"

        news12 = News()
        news12.photo = R.drawable.image11
        news12.inPhoto = R.drawable.image11
        news12.title = "نتنياهو عن اقتحام المسجد الأقصى وتطورات القدس الأخيرة"
        news12.date = "2021-05-08T15:49:59Z"
        news12.descreption =
            "قال رئيس الوزراء الإسرائيلي، بنيامين نتنياهو، إن إسرائيل تتصرف بمسؤولية من أجل تطبيق القانون،" +
                    " في معرض تعليقه على اقتحام المسجد الأقصى والاشتباكات الأخيرة في نطاقه، مساء الجمعة." + " \n " + " \n للمزيد من تفاصيل حول الخبر اذهب الى الموقع. "
        news12.link =
            "https://arabic.cnn.com/middle-east/article/2021/05/08/netanyahu-jerusalem-israel"

        var arr = arrayListOf<News>(
            news1, news2, news3, news4, news5, news6, news7, news8, news9, news10, news11, news12,
            news1, news2, news3, news4, news5, news6, news7, news8, news9, news10, news11, news12,
            news1, news2, news3, news4, news5, news6, news7, news8, news9, news10, news11, news12,
            news1, news2, news3, news4, news5, news6, news7, news8, news9, news10, news11, news12,
            news1, news2, news3, news4, news5, news6, news7, news8, news9, news10, news11, news12,
            news1, news2, news3, news4, news5, news6, news7, news8, news9, news10, news11, news12,
            news1, news2, news3, news4, news5, news6, news7, news8, news9, news10, news11, news12
        )

        val adapter_view =
            News_adapter(R.layout.news, arr, this)//this => dialog يحتاج الواجهة الي انا فيها
            newsRes.adapter = adapter_view //list matches adapter

        val m = LinearLayoutManager(this)
        m.orientation = LinearLayoutManager.VERTICAL
        newsRes.layoutManager = m

        //add divider
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL) // حسب layout
        val d = resources.getDrawable(R.drawable.vv)//return object drawable
        divider.setDrawable(d)//add Icon
        newsRes.addItemDecoration(divider)



         saveFirebase()
         readFirebase()
         getRegToken()
    }

    fun saveFirebase() {
        val map1: HashMap<String, Any> = HashMap()
        val map2: HashMap<String, Any> = HashMap()
        val map3: HashMap<String, Any> = HashMap()
        val map4: HashMap<String, Any> = HashMap()
        val map5: HashMap<String, Any> = HashMap()
        val map6: HashMap<String, Any> = HashMap()
        val map7: HashMap<String, Any> = HashMap()
        val map8: HashMap<String, Any> = HashMap()
        val map9: HashMap<String, Any> = HashMap()
        val map10: HashMap<String, Any> = HashMap()
        val map11: HashMap<String, Any> = HashMap()
        val map12: HashMap<String, Any> = HashMap()

        map1["title:news1"] = news1.title
        map1["date:news1"] = news1.date
        map1["descreption:news1"] = news1.descreption
        map1["link:news1"] = news1.link

        map2["title:news2"] = news2.title
        map2["date:news2"] = news2.date
        map2["descreption:news2"] = news2.descreption
        map2["link:news2"] = news2.link

        map3["title:news3"] = news3.title
        map3["date:news3"] = news3.date
        map3["descreption:news3"] = news3.descreption
        map3["link:news3"] = news3.link

        map4["title:news4"] = news4.title
        map4["date:news4"] = news4.date
        map4["descreption:news4"] = news4.descreption
        map4["link:news4"] = news4.link

        map5["title:news5"] = news5.title
        map5["date:news5"] = news5.date
        map5["descreption:news5"] = news5.descreption
        map5["link:news5"] = news5.link

        map6["title:news6"] = news6.title
        map6["date:news6"] = news6.date
        map6["descreption:news6"] = news6.descreption
        map6["link:news6"] = news6.link

        map7["title:news7"] = news7.title
        map7["date:news7"] = news7.date
        map7["descreption:news7"] = news7.descreption
        map7["link:news7"] = news7.link

        map8["title:news8"] = news8.title
        map8["date:news8"] = news8.date
        map8["descreption:news8"] = news8.descreption
        map8["link:news8"] = news8.link

        map9["title:news9"] = news9.title
        map9["date:news9"] = news9.date
        map9["descreption:news9"] = news9.descreption
        map9["link:news9"] = news9.link

        map10["title:news10"] = news10.title
        map10["date:news10"] = news10.date
        map10["descreption:news10"] = news10.descreption
        map10["link:news10"] = news10.link

        map11["title:news11"] = news11.title
        map11["date:news11"] = news11.date
        map11["descreption:news11"] = news11.descreption
        map11["link:news11"] = news11.link

        map12["title:news12"] = news12.title
        map12["date:news12"] = news12.date
        map12["descreption:news12"] = news12.descreption
        map12["link:news12"] = news12.link

        db.collection("News")
            .add(map1)
        db.collection("News")
            .add(map2)
        db.collection("News")
            .add(map3)
        db.collection("News")
            .add(map4)
        db.collection("News")
            .add(map5)
        db.collection("News")
            .add(map6)
        db.collection("News")
            .add(map7)
        db.collection("News")
            .add(map8)
        db.collection("News")
            .add(map9)
        db.collection("News")
            .add(map10)
        db.collection("News")
            .add(map11)
        db.collection("News")
            .add(map12)
            .addOnSuccessListener { documentReference ->
                Log.d(
                    "TAG", "DocumentSnapshot added with ID: " + documentReference.id
                )
            }
            .addOnFailureListener { e ->
                Log.w(
                    "TAG", "Error adding document", e
                )
            }

    }

    fun readFirebase() {
        db.collection("News")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        Log.d("TAG", document.id + " => " + document.data)
                    }
                } else {
                    Log.w("TAG", "Error getting documents.", task.exception)
                }
            }
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        //item.itemId == android.R.id.home //solution 1
//
//        if (toogle.onOptionsItemSelected(item)) {
//            //excute code
//            Toast.makeText(applicationContext, "=============", Toast.LENGTH_LONG).show()
//
//        }
//        return super.onOptionsItemSelected(item)
//    }

        //specific Notification
    fun getRegToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("TAG", "Failed to get token")
                return@OnCompleteListener
            }
            val token = task.result
            Log.d("TAG", "Token: $token")
        })
    }
}

