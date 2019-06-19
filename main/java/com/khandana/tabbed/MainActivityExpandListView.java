package com.khandana.tabbed;

import android.accessibilityservice.GestureDescription;
import android.app.AlertDialog;
import android.app.ExpandableListActivity;
import android.app.assist.AssistStructure;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import com.khandana.tabbed.Settings.BaseActivity;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MainActivityExpandListView extends BaseActivity {

    private LinkedHashMap<String, GroupInfo> subjects = new LinkedHashMap<String, GroupInfo>();
    private ArrayList<GroupInfo> deptList = new ArrayList<GroupInfo>();

    private CustomAdapter listAdapter;
    private ExpandableListView simpleExpandableListView;

    boolean isExpand = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_expand_listview);

        // add data for displaying in expandable list view
        loadData();

        //get reference of the ExpandableListView
        simpleExpandableListView = (ExpandableListView) findViewById(R.id.simpleExpandableListView);
        // create the adapter by passing your ArrayList data
        listAdapter = new CustomAdapter(MainActivityExpandListView.this, deptList);
        // attach the adapter to the expandable list view
        simpleExpandableListView.setAdapter(listAdapter);

        // setOnChildClickListener listener for child row click
        simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //get the group header
                GroupInfo headerInfo = deptList.get(groupPosition);
                //get the child info
                ChildInfo detailInfo = headerInfo.getProductList().get(childPosition);
                return false;
            }
        });

        // setOnGroupClickListener listener for group heading click
        simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //get the group header
                GroupInfo headerInfo = deptList.get(groupPosition);


                return false;
            }
        });
    }


    //method to expand all groups
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            simpleExpandableListView.expandGroup(i);
        }
    }

    //method to collapse all groups
    private void collapseAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            simpleExpandableListView.collapseGroup(i);
        }
    }

    public void expandCollapse(View view) {
        if (isExpand) {
            //collapse all the Groups
            collapseAll();
            isExpand = false;
        } else {
            //expand all the Groups
            expandAll();
            isExpand = true;
        }
    }

    //load some initial data into out list
    private void loadData() {

        addProduct("أَبْـدَأُ بِـسْمِ اللهِ وَالرَّحْـمَنِ (1) وَبِالرَّحِـيْـمِ دَائـِمِ اْلإِحْـسَانِ",
                "Arti : \n\n1. Saya (Mushonnif / Pengarang Kitab) memulai dengan menyebut nama Allah," +
                        " Dzat yang maha pengasih, dan Maha Penyayang yang senatiasa memberikan kenikmatan tiada putusnya. \n\n\n" +
                        "Penjelasan : \n\nKiyai Nadhim (Syekh Ahmad Marzuqi) mengatakan ; \"dalam menyusun kitab Aqidatul Awam ini saya mulai dengan " +
                        "menyebut Nama Allah Yang Maha Pengasih lagi Maha Penyayang serta abadi kebaikan-Nya\".");

        addProduct("فَالْحَـمْـدُ ِللهِ الْـقَدِيْمِ اْلأَوَّلِ (2) اَلآخِـرِ الْبَـاقـِيْ بِلاَ تَحَـوُّلِ" ,
                "Arti : \n\n2. Maka segala puji bagi Allah Yang Maha Dahulu, Yang Maha Awal, Yang Maha Akhir, Yang Maha Tetap tanpa ada perubahan\n\n\n" +
                        "Penjelasan : \n\nMaka dari itu segala puji saya panjatkan hanya terhadap Allah Subhanahuwata'ala." +
                        " yang memiliki sifat qodim, sifat awwal, sifat akhir serta sifat baqo' (tanpa ada perubahan).");

        addProduct("ثُمَّ الـصَّلاَةُ وَالسَّلاَمُ سَـرْمَدَا (3) عَلَى الـنَّـبِيِّ خَيْرِ مَنْ قَدْ وَحَّدَا",
                "Arti : \n\n3. Kemudian, semoga sholawat dan salam senantiasa tercurahkan pada Nabi sebaik-baiknya orang yang mengEsakan Allah\n\n\n" +
                        "Penjelasan : \n\nKemudian beliau mendo'akan; \"Semoga rahmat ta'zhim Allah serta keselamatan-Nya ditetapkan atas Nabi Muhammad" +
                        " Salallahualai Wasalam\".");

        addProduct("وَآلِهِ وَصَـحْبِهِ وَمَـنْ تَـبِـعْ (4) سَـبِيْلَ دِيْنِ الْحَقِّ غَيْرَ مُـبْـتَدِعْ",
                "Arti : \n\n4. Dan keluarganya, para sahabatnya dan orang-orang yang mengikuti jalan agama secara benar " +
                        "bukan orang-orang yang berbuat bid’ah\n\n\n" +
                        "Penjelasan : \n\nBeserta keluarganya, Sahabat-sahabatnya serta Orang-orang yang mengikuti terhadap jalan agama yang benar," +
                        " yakni Agama Islam.");

        addProduct("وَبَعْدُ فَاعْلَمْ بِوُجُوْبِ الْمَعْرِفَـهْ (5) مِنْ وَاجِـبٍ ِللهِ عِشْـرِيْنَ صِفَهْ",
                "Arti : \n\n5. Dan setelahnya ketahuilah dengan yakin bahwa Allah itu mempunyai 20 sifat wajib\n\n\n" +
                        "Penjelasan : \n\nSetelah memanjatkan puji dan do'a terhadap Allah Subhanahu Wata'ala., beliau menegaskan bahwa semua orang mukalaf wajib mengetahui" +
                        " dan meyakini terhadap sifat-sifat Allah banyaknya dua puluh (20).");

        addProduct("فَاللهُ مَوْجُـوْدٌ قَـدِيْمٌ بَاقِـي (6) مُخَالـِفٌ لِلْـخَـلْقِ بِاْلإِطْلاَقِ",
                "Arti : \n\n6. Allah itu Ada, Qodim, Baqi dan berbeda dengan makhlukNya secara mutlak\n\n\n" +
                        "Penjelasan : \n\nSifat Wajib Allah SWT yang dua puluh tersebut adalah sebagai berikut:\n" +
                        "\n" +
                        "1. Wujud artinya Ada\n" +
                        "2. Qidam artinya Dahulu\n" +
                        "3. Baqa’ artinya Kekal\n" +
                        "4. Mukhalafatu Lilhawaditsi artinya Berbeda dengan yang baru (tidak sama dengan makhluknya)\n");

        addProduct("وَقَـائِمٌ غَـنِيْ وَوَاحِـدٌ وَحَيّ (7) قَـادِرْ مُـرِيْـدٌ عَـالِمٌ بِكُلِّ شَيْ",
                "Arti : \n\n7. Berdiri sendiri, Maha Kaya, Maha Esa, Maha Hidup, Maha Kuasa, Maha Menghendaki, Maha Mengetahui atas segala sesuatu\n\n\n" +
                        "Penjelasan : \n\n5. Qiyamuhu Binafsih artinya berdiri sendiri\n" +
                        "6.  Wahdaniyat artinya Esa/satu\n"+
                        "7.  Qudrat artinya Kuasa\n" +
                        "8.  Iradah artinya Berkehendak\n" +
                        "9.  Ilmu artinya Mengetahui\n" +
                        "10. Hayat artinya Hidup\n");

        addProduct("سَـمِـيْعٌ اْلبَصِـيْرُ وَالْمُتَكَلِّـمُ (8) لَهُ صِـفَاتٌ سَـبْعَـةٌ تَـنْـتَظِمُ",
                "Arti : \n\n8. Maha Mendengar, Maha Melihat, Maha Berbicara, Allah mempunyai 7 sifat yang tersusun\n\n\n" +
                        "Penjelasan : \n\n11. Sama’ (Mendengar)\n" +
                        "12. Bashor (Melihat)\n" +
                        "13. Kalam (Berfirman)\n");

        addProduct("فَقُـدْرَةٌ إِرَادَةٌ سـَمْـعٌ بـَصَرْ (9) حَـيَـاةٌ الْعِلْـمُ كَلاَمٌ اسْـتَمَرْ",
                "Arti : \n\n9. yaitu Berkuasa, Menghendaki, Mendengar, Melihat, Hidup, Mempunyai Ilmu, Berbicara secara terus berlangsung\n\n\n" +
                        "Penjelasan : \n\nPada bait-bait seblumnya telah dijelaskan jika Allah Ta’ala mempunyai sifat berkuasa, berkehendak, berilmu, hidup, mendengar, melihat, dan berbicara (berfirman). Dengan demikian, maka secara otomatis Allah Ta’ala mempunyai sifat-sifat berikut ini :\n" +
                        "\n" +
                        "14. Qodiroon (Dialah Yang Maha Kuasa)\n" +
                        "15. Muriidan (Dialah Yang Maha Berkehendak)\n" +
                        "16. Aaliman (Dialah Yang Maha Mengetahui)\n" +
                        "17. Samii'an (Dialah Yang Maha Mendengar)\n" +
                        "18. Hayyan (Dialah Yang Maha Hidup)\n" +
                        "19. Bashiiron (Dialah Yang Maha Melihat)\n" +
                        "20. Mutakalliman (Dialah Yang Maha Berbicara)\n");


        addProduct("وَجَائـِزٌ بِـفَـضْـلِهِ وَ عَدْلِهِ (10) تَـرْكٌ لـِكُلِّ مُمْـكِـنٍ كَفِعْلِهِ",
                "Arti : \n\n10. Dengan karunia dan keadilanNya, Allah memiliki sifat boleh (wenang) yaitu boleh mengerjakan sesuatu atau meninggalkannya\n\n\n" +
                        "Penjelasan : \n\nSifat jaiz Allah SWT ada satu, yakni:\n" +
                        "\n" +
                        "فِعْلُ كُلِّ مُمْكِنٍ أَوْ تَرْكُهُ\n" + "\nAllah Subhanahu Wata'ala. wenang melakukan atau tidak melakukan sesuatu, contoh ; Allah Subhanahu Wata'ala. memberikan pahala terhadap orang yang" +
                        " taat disebabkan anugrah Allah semata, begitu pula Allah menyiksa orang yang melakukan maksiat disebabkan keadilan-Nya.");


        addProduct("أَرْسَـلَ أَنْبِيَا ذَوِي فَـطَـانَـهْ (11) بِالصِّـدْقِ وَالتَـبْلِـيْغِ وَاْلأَمَانَهْ",
                "Arti : \n\n11. Allah telah mengutus para nabi yang memiliki 4 " +
                        "sifat yang wajib yaitu cerdas, jujur, menyampaikan (risalah) dan dipercaya\n\n\n" +
                        "Penjelasan : \n\n1. Shiddiq artinya benar dan tidak bohong\n" +
                        "2. Amanah artinya dilindungi dari perbuatan maksiat (jujur)\n" +
                        "3. Tabligh artinya menyampaikan segala apa yang diperintahkanoleh Allah Subhanahu Wata'ala.\n" +
                        "4. Fathonah artinya cerdik atau tanggap\n");


        addProduct("وَجَـائِزٌ فِي حَـقِّهِمْ مِنْ عَرَضِ (12) بِغَيْـرِ نَقْصٍ كَخَـفِيْفِ الْمَرَضِ",
                "Arti : \n\n12. Dan boleh didalam hak Rosul dari sifat manusia tanpa" +
                        " mengurangi derajatnya,misalnya sakit yang ringan\n\n\n" +
                        "Penjelasan : \n\nSetiap orang mukalaf wajib meyakini hak sifat jaiz para Rasul yang adanya hanya satu (1) yaitu, sifat yang mungkin dimiliki oleh setiap manusia biasa," +
                        " seperti, makan, minum, kawin, sakit, dan lain sebagainya. Hanya kendati demikian tidak mengurangi terhadap derajat para Rasul tersebut\n");


        addProduct("عِصْـمَـتُهُمْ كَسَائِرِ الْمَلاَئِكَهْ (13) وَاجِـبَـةٌ وَفَاضَلُوا الْمَـلاَئِكَهْ",
                "Arti : \n\n13. Mereka mendapat penjagaan Allah (dari perbuatan dosa) seperti para malaikat seluruhnya. " +
                        "(Penjagaan itu) wajib bahkan para Nabi lebih utama dari para malaikat\n\n\n" +
                        "Penjelasan : \n\nSetiap orang mukalaf juga wajib meyakini bahwa para Nabi dari para Rasul itu maksum (dilindungi oleh Allah dari melakukan dosa), " +
                        "seperti perlindungan Allah terhadap para Malaikat. Hanya pangkat mereka melebihi derajat para Malaikat.");


        addProduct("وَالْمُسْـتَحِيْلُ ضِدُّ كُلِّ وَاجِبِ (14) فَاحْفَظْ لِخَمْسِـيْنَ بِحُكْمٍ وَاجِبِ",
                "Arti : \n\n14. Dan sifat mustahil adalah lawan dari sifat yang wajib maka hafalkanlah 50 sifat itu sebagai ketentuan yang wajib\n\n\n" +
                        "Penjelasan : \n\nSifat muhal merupakan lawan dan sifat wajib, maka dari itu wajib hukumnya bagi setiap orang mukalaf mengetahui dan hafal aqoid lima puluh (50), yaitu;\n" +
                        "- Sifat wajib bagi Allah\t= 20\n" +
                        "- Sifat muhal bagi Allah\t= 20\n" +
                        "- Sifat jaiz bagi Allah\t=   1\n" +
                        "- Sifat wajib bagi Rasul\t=   4\n" +
                        "- Sifat muhal bagi Rasul\t=   4\n" +
                        "- Sifat jaiz bagi Rasul\t=   1\n" +
                        "   Jumlah\t\t    50\n" +
                        "\n" +
                        "Perincian sifat mustahil bagi para rasul tersebut adalah sebagai berikut.:\n" +
                        "- Shidiq (jujur) >< Kidzib (dusta)\n" +
                        "- Amanah (dapat dipercaya) >< Khiyanat (tidak dapat dipercaya)\n" +
                        "- Tabligh (menyampaikan wahyu) >< Kitman (menyembunyikan wahyu)\n" +
                        "- Fathonah (cerdas) >< Baladah (bodoh)\n");


        addProduct("تَفْصِيْلُ خَمْسَةٍ وَعِشْـرِيْنَ لَزِمْ (15) كُـلَّ مُـكَلَّـفٍ فَحَقِّقْ وَاغْـتَنِمْ",
                "Arti : \n\n15. Adapun rincian nama para Rosul ada 25 itu wajib diketahui bagi setiap mukallaf, maka yakinilah dan ambilah keuntungannya\n\n\n" +
                        "Penjelasan : \n\nWajib hukumnya bagi setiap orang mukalaf mengetahui secara rinci jumlah " +
                        "Para Rasul yang banyaknya dua puluh lima (25)");


        addProduct("هُمْ آدَمٌ اِدْرِيْسُ نُوْحٌ هُـوْدُ مَعْ (16) صَالِـحْ وَإِبْرَاهِـيْـمُ كُلٌّ مُـتَّبَعْ",
                "Arti : \n\n16. Mereka adalah Nabi Adam, Idris, Nuh, Hud serta Sholeh, Ibrahim " +
                        "( yang masing-masing diikuti berikutnya)\n\n\n");


        addProduct("لُوْطٌ وَاِسْـمَاعِيْلُ اِسْحَاقُ كَذَا (17) يَعْقُوبُ يُوسُـفُ وَأَيُّوْبُ احْتَذَى",
                "Arti : \n\n17. Luth, Ismail dan Ishaq demikian pula Ya'qub, Yusuf dan Ayyub dan selanjutnya\n\n\n");


        addProduct("شُعَيْبُ هَارُوْنُ وَمُوْسَى وَالْيَسَعْ (18) ذُو الْكِـفْلِ دَاوُدُ سُلَيْمَانُ اتَّـبَعْ",
                "Arti : \n\n18. Syuaib, Harun, Musa dan Alyasa', Dzulkifli, Dawud, Sulaiman yang diikuti\n\n\n");


        addProduct("إلْيَـاسُ يُوْنُسْ زَكَرِيـَّا يَحْيَى (19) عِيْسَـى وَطَـهَ خَاتِمٌ دَعْ غَـيَّا",
                "Arti : \n\n19. Ilyas, Yunus, Zakaria, Yahya, Isa dan Thaha (Muhammad)" +
                        " sebagai penutup, maka tinggalkanlah jalan yang menyimpang dari kebenaran\n\n\n");


        addProduct("عَلَـيْهِمُ الصَّـلاَةُ وَالسَّـلاَمُ (20) وَآلِـهِمْ مـَا دَامَـتِ اْلأَيـَّـامُ",
                "Arti : \n\n20. Semoga sholawat dan salam terkumpulkan pada mereka dan keluarga mereka sepanjang masa\n\n\n");


        addProduct("وَالْمَـلَكُ الَّـذِيْ بِلاَ أَبٍ وَأُمْ (21) لاَ أَكْلَ لاَ شُـرْبَ وَلاَ نَوْمَ لَـهُمْ",
                "Arti : \n\n21. Adapun para malaikat itu tetap tanpa bapak dan ibu," +
                        " tidak makan dan tidak minum serta tidak tidur\n\n\n" +
                        "Penjelasan : \n\nSemua orang mukalaf wajib mengetahui bahwa Allah Subhanahu Wata'la. menciptakan setiap malaikat tanpa perantara seorang bapak dan seorang ibu," +
                        " mereka bukan laki-laki, bukan perempuan, dan bukan pula banci. Mereka tidak makan, tidak minum serta tidak tidur\n");


        addProduct("تَفْـصِـيْلُ عَشْرٍ مِنْهُمُ جِبْرِيْلُ (22) مِـيْـكَـالُ اِسْـرَافِيْلُ عِزْرَائِيْلُ",
                "Arti : \n\n22. Secara terperinci mereka ada 10, yaitu Jibril, Mikail, Isrofil, dan Izroil\n\n\n" +
                        "Penjelasan : \n\nAllah menciptakan beberapa Malaikat yang jumlahnya tidak ada yang mengetahui kecuali Allah sendiri, namun ada sepuluh malaikat yang wajib diketahui nama-namanya dan diyakini kebenarannya oleh setiap orang mukalaf yaitu :\n" +
                        "1.      Malaikat Jibril bertugas menyampaikan wahyu Allah Subhanahu Wata'ala\n" +
                        "2.      Malaikat Mika’il bertugas memberikan rizki.\n" +
                        "3.      Malaikat Izra’il bertugas mencabut arwah.\n" +
                        "4.      Malaikat Israfil bertugas meniup terompet pertanda hari kiamat.");


        addProduct("مُنْـكَرْ نَكِـيْرٌ وَرَقِيْبٌ وَكَذَا (23) عَتِـيْدٌ مَالِكٌ ورِضْوَانُ احْتَـذَى",
                "Arti : \n\n23. Munkar, Nakiir, dan Roqiib, demikian pula ‘Atiid, Maalik, dan Ridwan dan selanjutnya\n\n\n" +
                        "Penjelasan : \n\n5.      Malaikat Munkar yang bertugas menanyakan dan melakukan pemeriksaan pada amal perbuatan manusia di alam kubur.\n" +
                        "6.      Malaikat Nakir yang bertugas menanyakan dan melakukan pemeriksaan pada amal perbuatan manusia di alam kubur bersama Malaikat Munkar.\n" +
                        "7.      Malaikat Raqib / Rokib yang memiliki tanggung jawab untuk mencatat segala amal baik manusia ketika hidup.\n" +
                        "8.      Malaikat Atid / Atit yang memiliki tanggungjawab untuk mencatat segala perbuatan buruk / jahat manusia ketika hidup.\n" +
                        "9.      Malaikat Malik yang memiliki tugas untuk menjaga pintu neraka.\n" +
                        "10.  Malaikat Ridwan yang berwenang untuk menjaga pintu sorga / surga.\n");


        addProduct("أَرْبَـعَـةٌ مِنْ كُتُبٍ تَـفْصِيْلُهَا (24) تَوْارَةُ مُوْسَى بِالْهُدَى تَـنْـزِيْلُهَا",
                "Arti : \n\n24. Empat dari Kitab-Kitab Suci Allah secara terperinci " +
                        "adalah Taurat bagi Nabi Musa diturunkan dengan membawa petunjuk\n\n\n" +
                        "Penjelasan : \n\nAllah Subhanahu Wata'ala. menurunkan empat (4) kitab kepada para Nabi dan RasulNya, yang wajib iketahui dan diyakini oleh setiap orang mukalaf, yaitu;\n" +
                        "1. Kitab Taurot yang diturunkan kepada Nabi Musa Alaihi Salam");


        addProduct("زَبُـوْرُ دَاوُدَ وَاِنْجِـيْـلُ عَلَى (25) عِيْـسَى وَفُـرْقَانُ عَلَى خَيْرِ الْمَلاَ",
                "Arti : \n\n25. Zabur bagi Nabi Dawud dan Injil bagi Nabi Isa dan AlQur’an bagi " +
                        "sebaik-baik kaum (Nabi Muhammad Salallahualaihi Wasalam)\n\n\n" +
                        "Penjelasan : \n\n2.      Kita suci Zabur; yang diturunkan kepada Nabi Dawud Alaihi Salam" +
                        "\n" +
                        "3.      Kitab suci Injil; diturunkan kepada Nabi Isa Alaihi Salam" +
                        "\n" +
                        "4.      Kitab suci Al-Qur’an; diturunkan kepada Nabi Muhammad Salallahualaihi Wasalam" +
                        "\n");


        addProduct("وَصُحُـفُ الْخَـلِيْلِ وَالْكَلِيْمِ (26) فِيْهَـا كَلاَمُ الْـحَـكَمِ الْعَلِـيْمِ",
                "Arti : \n\n26. Dan lembaran-lembaran (Shuhuf) suci yang diturunkan untuk AlKholil (Nabi Ibrohim) dan " +
                        "AlKaliim (Nabi Musa) mengandung Perkataan dari Yang Maha Bijaksana dan Maha Mengetahui\n\n\n" +
                        "Penjelasan : \n\nSetiap orang mukalaf wajib meyakini bahwa Allah Subhanahu Wata'ala. disamping menurunkan empat kitab juga menurunkan beberapa mushhaf " +
                        " (lembaran-lembaran) kepada Nabi Musa Alaihi Salam dan Nabi Ibrahim Alaihi Salam, sedang jumlahnya tidak wajib diketahui");


        addProduct("وَكُـلُّ مَا أَتَى بِهِ الـرَّسُـوْلُ (27) فَحَـقُّـهُ التَّسْـلِـيْمُ وَالْقَبُوْلُ",
                "Arti : \n\n27. Dan segala apa-apa yang disampaikan oleh Rosulullah, maka kita wajib pasrah dan menerima\n\n\n" +
                        "Penjelasan : \n\nKita (sebagai orang mukalaf) wajib" +
                        " menerima dan membenarkan terhadap apa yang disabdakan oleh Rasulullah (Nabi Muhammad Salallahualaihi Wasalam).");


        addProduct("إِيْـمَـانُنَا بِـيَوْمِ آخِرٍ وَجَبْ (28) وَكُلِّ مَـا كَانَ بِـهِ مِنَ الْعَجَبْ",
                "Arti : \n\n28. Keimanan kita kepada Hari Akhir hukumnya wajib, dan segala perkara yang dahsyat pada Hari Akhir\n\n\n" +
                        "Penjelasan : \n\nKita wajib meyakini dengan sepenuh hati bahwa kelak akan ada hari akhir (hari kiamat), dimana pada saat itu kita akan menjumpai beberapa keajaiban seperti; setelah semua manusia dibangkitkan lalu dikumpulkan di padang mahsyar untuk ditimbang amalnya, guna mengetahui baik buruknya amal yang telah dilakukan di dunia dan lain sebagainya. Keanehan yang wajib diyakini dengans sepenuh hati oleh setiap mukalaf pada hari akhir antara lain :\n" +
                        "a. Hari Ba'ats artinya hari kebangkitan\n" +
                        "b. Mahsyar artinya tempat berkumpulnya manusia setelah dihidupkan kembali untuk dihisab\n" +
                        "c. Mizan, timbangan amal-amal manusia\n" +
                        "d. Sirath, jembatan yang melentang di atas neraka untuk menuju ke surga");


        addProduct("خَاتِمَةٌ فِي ذِكْرِ بَاقِي الْوَاجِبِ (29) مِمَّـا عَـلَى مُكَلَّفٍ مِنْ وَاجِبِ",
                "Arti : \n\n29. Sebagai penutup untuk menerangkan ketetapan yang wajib," +
                        " dari hal yang menjadi kewajiban bagi mukallaf\n\n\n" +
                        "Penjelasan : \n\nDi bawah ini merupakan bahasan terakhir yang menerangkan tentang sesuatu yang wajib diyakini bagi setiap orang mukalaf");


        addProduct("نَبِـيُّـنَا مُحَمَّدٌ قَدْ أُرْسِــلاَ (30) لِلْـعَالَمِـيْـنَ رَحْـمَةً وَفُضِّلاَ",
                "Arti : \n\n30. Nabi kita Muhammad telah diutus untuk seluruh alam sebagai" +
                        " Rahmat dan keutamaan diberikan kepada beliau SAW melebihi semua\n\n\n" +
                        "Penjelasan : \n\nKita wajib meyakini bahwa Nabi Muhammad Salallahualaihi wasalam. diutus oleh Allah sebagai rahmat bagi alam semesta sebagaimana firmanNya :\n" +
                        "وَمَا أَرْسَلْنَاكَ إِلاَّ رَحْمَةً لِلْعَالَمِينَ. (الأنبياء، 107).\n" +
                        " Dan tiadalah Kami mengutus kamu, melainkan untuk (menjadi) rahmat bagi semesta alam.” (QS. Al-Anbiya’ : 107).");


        addProduct("أَبـُوْهُ عَبْدُ اللهِ عَبْدُ الْمُطَّلِـبْ (31) وَهَاشِـمٌ عَبْدُ مَنَافٍ يَنْتَسِـبْ",
                "Arti : \n\n31. Ayahnya bernama Abdullah putera Abdul Mutthalib, dan nasabnya " +
                        "bersambung kepada Hasyim putera Abdu Manaf\n\n\n" +
                        "Penjelasan : \n\nSetiap orang mukalaf wajib mengetahui tentang silsilah Nabi Muhammad Salallahualaihi Wasalam., baik dari ibunya maupun dari ayah Nabi,\n" +
                        "* Silsilah Nabi Muhammad yang datang dari ayah Nabi Muhammad Salallahualaihi Wasalam., adalah putra dan Sayyid Abdullah bin Abdul Muthollib bin Hasyim bin Abdi Manaf bin Qushoy bin Kilab bin Murroh bin Ka'ab bin Luaiyibni Gholib bin Fihir bin Malik bin " +
                        "Nadhor bin Kinaanah bin Huzaimah bin Mudrikah bin Ilyas bin Mudhor bin Nizar bin Mu'ad bin 'Adnaan");


        addProduct("وَأُمُّـهُ آمِـنَةُ الـزُّهْــرِيـَّهْ (32) أَرْضَـعَتْهُ حَلِيْمَـةُ السَّـعْدِيـَّهْ",
                "Arti : \n\n32. Dan ibunya bernama Aminah Az-Zuhriyyah, yang menyusui beliau adalah Halimah As-Sa’diyyah\n\n\n" +
                        "Penjelasan : \n\n* Silsilah Nabi Muhammad yang datang dari ibunya Nabi Muhammad Salallahualaihi Wasalam adalah putra dan Salyidatina " +
                        "Aminah binti Wahbin bin Abdi Manar bin Zuhroh bin Kilab");


        addProduct("مَوْلـِدُهُ بِمَـكَّـةَ اْلأَمِيْــنَهْ (33) وَفَاتُـهُ بِـطَـيْـبَةَ الْـمَدِيْنَهْ",
                "Arti : \n\n33. Lahirnya di Makkah yang aman, dan wafatnya di Toiybah (Madinah)\n\n\n" +
                        "Penjelasan : \n\nNabi Muhammad Salallahualaihi Wasalam. lahir di Kota Mekkah dan meninggal di kota Madinah");


        addProduct("أَتَـمَّ قَـبْـلَ الْـوَحْيِ أَرْبَعِيْنَا (34) وَعُـمْـرُهُ قَدْ جَاوَزَ السِّـتِّيْنَا",
                "Arti : \n\n34. Sebelum turun wahyu, nabi Muhammad telah sempurna berumur 40 tahun," +
                        " dan usia beliau 60 tahun lebih\n\n\n" +
                        "Penjelasan : \n\nKemudian beliau memperoleh wahyu dari Allah Subhanahu Wata'ala. setelah berumur empat puluh (40) tahun, " +
                        "dan meninggal setelah lewat umur enam puluh (60) tahun, (yaitu enam puluh tiga (63) tahun).");


        addProduct("وَسَـبْـعَةٌ أَوْلاَدُهُ فَمِـنْـهُمُ (35) ثَلاثَـةٌ مِـنَ الذُّكـُوْرِ تُـفْهَمُ",
                "Arti : \n\n35. Ada 7 orang putera-puteri nabi Muhammad, diantara mereka 3 " +
                        "orang laki-laki, maka pahamilah itu\n\n\n" +
                        "Penjelasan : \n\nRasulullah Salallahualaihi Wasalam memiliki 7 orang anak, dengan perincian 3 orang putra dan 4 orang putri. Keterangan mengenai nama-nama putra dan putri Nabi Muhammad Salallahualaihi Wasalam" +
                        " akan dijelaskan oleh mushonnif (pengarang kitab) dalam bait selanjutnya.");


        addProduct("قَاسِـمْ وَعَبْدُ اللهِ وَهْوَ الطَّيِّبُ (36) وَطَاهِـرٌ بِذَيْـنِ ذَا يُـلَـقَّبُ",
                "Arti : \n\n36. Qasim dan Abdullah yang bergelar At-Thoyyib dan At-Thohir," +
                        " dengan 2 sebutan inilah (At-Thoyyib dan At-Thohir) Abdullah diberi gelar\n\n\n" +
                        "Penjelasan : \n\nPutra pertama Nabi Muhammad Salallahualaihi Wasalam bernama Qasim. " +
                        "Nama putra kedua Nabi Muhammad SAW adalah Abdullah, yang disebut juga at-Thayyib (Baik) dan at-Thahir (Bersih/Suci)\n");


        addProduct("أَتَاهُ إبْرَاهِـيْـمُ مِنْ سُـرِّيـَّهْ (37) فَأُمُّـهُ مَارِيَّةُ الْـقِـبْـطِـيَّـهْ",
                "Arti : \n\n37. Anak yang ketiga bernama Ibrohim dari Sariyyah " +
                        "(Amat perempuan), ibunya (Ibrohim) bernama Mariyah Al-Qibtiyyah\n\n\n" +
                        "Penjelasan : \n\nPutra ketiga Rasulullah bernama Ibrahim." +
                        " Ibrahim lahir dari rahim Mariyah al-Qibthiyyah.");


        addProduct("وَغَيْـرُ إِبْرَاهِيْمَ مِنْ خَـدِيْجَهْ (38) هُمْ سِتَـةٌ فَخُـذْ بِهِمْ وَلِـيْجَهْ",
                "Arti : \n\n38. Selain Ibrohim, ibu putera-puteri Nabi Muhammad berasal dari" +
                        " Khodijah, mereka ada 6 orang (selain Ibrohim), maka kenalilah dengan penuh cinta\n\n\n" +
                        "Penjelasan : \n\nSelain Ibrahim, lahir dari rahim ibu Mariyah al-Qibthiyyah. " +
                        "Semua putra-putri Nabi Muhammad Salallahualaihi Wasalam. yang pertama, yaitu Siti Khadijah Radhiallahu 'Anhu." +
                        " Semua putri (anak perempuan) Rasulullah Salallahualaihi Wasalam.");


        addProduct("وَأَرْبَعٌ مِـنَ اْلإِنَاثِ تُـذْكَـرُ (39) رِضْـوَانُ رَبِّي لِلْجَمِـيْعِ يُذْكَرُ",
                "Arti : \n\n39. Dan 4 orang anak perempuan Nabi akan disebutkan, " +
                        "semoga keridhoan Allah untuk mereka semua\n\n\n" +
                        "Penjelasan : \n\nSelain memiliki 3 orang putra, Nabi Muhammad SAW mempunyai juga 4 orang putri." +
                        " Nama-nama putri (anak perempuan) Nabi Muhammad SAW akan disebutkan oleh mushonnif (pengarang kitab) dalam bait selanjutnya.");


        addProduct("فَاطِـمَـةُ الزَّهْرَاءُ بَعْلُهَا عَلِيْ (40) وَابْنَاهُمَا السِّـبْطَانِ فَضْلُهُمُ جَلِيْ",
                "Arti : \n\n40. Fatimah Az-Zahro yang bersuamikan Ali bin Abi Tholib, dan kedua " +
                        "putera mereka (Hasan dan Husein) adalah cucu Nabi yang sudah jelas keutamaanya\n\n\n");


        addProduct("فَزَيْـنَبٌ وَبَعْـدَهَـا رُقَـيَّهْ (41) وَأُمُّ كُـلْـثُـومٍ زَكَـتْ رَضِيَّهْ",

                "Arti : \n\n41. Kemudian Zaenab dan selanjutnya Ruqayyah, dan Ummu Kultsum yang suci lagi diridhoi\n\n\n" +
                        "Penjelasan : \n\nSemua adalah putra-putri bersama Siti Khadijah, kecuali Ibrohim putra dari Mariyatul Qibtiyah");


        addProduct("عَنْ تِسْعِ نِسْوَةٍ وَفَاةُ الْمُصْطَفَى (42) خُيِّـرْنَ فَاخْتَرْنَ النَّـبِيَّ الْمُقْتَفَى",
                "Arti : \n\n42. Dari 9 istri Nabi ditinggalkan setelah wafatnya, mereka semua telah" +
                        " diminta memilih syurga atu dunia, maka mereka memilih nabi sebagai panutan\n\n\n" +
                        "Penjelasan : \n\nIstri Nabi Muhammad Salallahualaihi Wasalam. jumlahnya sebelas (11), ketika nabi wafat tinggal sembilan orang," +
                        " mereka pernah dinasehati Nabi sebagai berikut : \"Mana suka antara kesenangan di dunia di banding dengan kesenangan di surga?.\" " +
                        "semua sama memilih kesenangan di surga, maksudnya memilih tunduk terhadap segala apa yang diperbuat oleh Nabi.");


        addProduct("عَائِشَـةٌ وَحَفْصَـةٌ وَسَـوْدَةُ (43) صَـفِيَّـةٌ مَـيْـمُـوْنَةٌ وَ رَمْلَةُ",
                "Arti : \n\n43. Aisyah, Hafshah, dan Saudah, Shofiyyah, Maimunah, dan Romlah\n\n\n" +
                        "Penjelasan : \n\nSedangkan yang dimaksud istri sembilan adalah : \n" +
                        "1. Siti Aisyah\n" +
                        "2. Siti Hafshoh\n" +
                        "3. Siti Saudah\n" +
                        "4. Siti Shofiyah\n" +
                        "5. Siti Maimunah\n" +
                        "6. Siti Romlah");


        addProduct("هِنْدٌ وَ زَيْـنَبٌ كَذَا جُوَيـْرِيَهْ (44) لِلْمُـؤْمِـنِيْنَ أُمَّـهَاتٌ مَرْضِـيَّهْ",
                "Arti : \n\n44. Hindun dan Zaenab, begitu pula Juwairiyyah, Bagi kaum Mu’minin mereka" +
                        " menjadi ibu-ibu yang diridhoi\n\n\n" +
                        "Penjelasan : \n\n7. Siti Hindun\n" +
                        "8. Siti Zainab\n" +
                        "9. Siti Zuwariyah\n" +
                        "\n" +
                        "Semua disebut Ummul Mukminin, maksudnya jadi ibunya/panutannya semua orang mukmin yang harus dihormati dan dimulyakan");


        addProduct("حَمْـزَةُ عَمُّـهُ وعَـبَّاسٌ كَذَا (45) عَمَّـتُـهُ صَـفِيَّـةٌ ذَاتُ احْتِذَا",
                "Arti : \n\n45. Hamzah adalah Paman Nabi demikian pula ‘Abbas, Bibi Nabi adalah Shofiyyah yang mengikuti Nabi\n\n\n" +
                        "Penjelasan : \n\nDari sekian banyak paman Nabi yang mashur hanya dua yaitu; Saiyidina Hamzah ra. dan Saiyidina Abbas ra.," +
                        " begitu pula bibinya yang mashur hanya satu yaitu; Siti Shofiyah");


        addProduct("وَقَبْـلَ هِجْـرَةِ النَّـبِيِّ اْلإِسْرَا (46) مِـنْ مَـكَّةَ لَيْلاً لِقُدْسٍ يُدْرَى",
                "Arti : \n\n46. Dan sebelum Nabi Hijrah (ke Madinah), terjadi peristiwa Isro’. " +
                        "Dari Makkah pada malam hari menuju Baitul Maqdis yang dapat dilihat\n\n\n" +
                        "Penjelasan : \n\nSetiap orang mukalaf juga wajib meyakini bahwa Nabi Muhammad Salallahualaihi Wasalam pernah " +
                        "di isro'kan (berjalan di waktu malam dari Masjidil Haram menuju Masjiil Aqsho).");


        addProduct("وَبَعْدَ إِسْـرَاءٍ عُرُوْجٌ لِلسَّـمَا (47) حَتَّى رَأَى النَّـبِيُّ رَبًّـا كَـلَّمَا",
                "Arti : \n\n47. Setelah Isro’ lalu Mi’roj (naik) keatas sehingga Nabi melihat Tuhan yang berkata-kata\n\n\n" +
                        "Penjelasan : \n\nKemudian setelah itu di mi'rojkan (dinaikkan oleh Allah Subhanahu Wata'ala sampai ke Mustawa)");


        addProduct("مِنْ غَيْرِكَيْفٍ وَانْحِصَارٍ وَافْـتَرَضْ (48) عَلَيْهِ خَمْسًا بَعْدَ خَمْسِيْنَ فَرَضْ",
                "Arti : \n\n48. Berkata-kata tanpa bentuk dan ruang. Disinilah diwajibkan kepadanya" +
                        " (sholat) 5 waktu yang sebelumnya 50 waktu\n\n\n" +
                        "Penjelasan : \n\nPada saat itulah Nabi Muhammad Salallahualaihi Wasalam menerima perintah langsung dari" +
                        " Allah Subhanahu Wata'ala. berupa shalat lima (5) waktu, yang mana sampai sekarang tetap diwajibkan terhadap semua ummatnya.");


        addProduct("وَبَـلَّـغَ اْلأُمَّـةَ بِاْلإِسْــرَاءِ (49) وَفَـرْضِ خَـمْـسَةٍ بِلاَ امْتِرَاءِ",
                "Arti : \n\n49. Dan Nabi telah menyampaikan kepada umat peristiwa Isro’ tersebut. " +
                        "Dan kewajiban sholat 5 waktu tanpa keraguan\n\n\n" +
                        "Penjelasan : \n\nSetelah Nabi Muhammad Salallahualaihi Wasalam. melakukan isro' mi'roj, lalu beliau menyampaikan kepada ummatnya " +
                        "tentang diwajibkannya melaksanakan sholat lima (5) waktu dengan tanpa ragu-ragu");


        addProduct("قَدْ فَازَ صِـدِّيْقٌ بِتَصْـدِيْقٍ لَهُ (50) وَبِالْعُرُوْجِ الصِّـدْقُ وَافَى أَهْلَهُ",
                "Arti : \n\n50. Sungguh beruntung sahabat Abubakar As-Shiddiq dengan membenarkan peristiwa tersebut, juga " +
                        "peristiwa Mi’raj yang sudah sepantasnya kebenaran itu disandang bagi pelaku Isro’ Mi’roj\n\n\n" +
                        "Penjelasan : \n\nSayyidina Abu Bakar benar-benar bahagia mendengar keterangan Nabi Muhammad Salallahualaihi Wasalam.," +
                        " dan langsung percaya serta membenarkan terhadap isro' mi'roj Nabi, maka dari itu beliau deberi gelar \"Ash-shiddiq\"");


        addProduct("وَهَـذِهِ عَقِيْـدَةٌ مُخْـتَصَرَهْ (51) وَلِلْـعَـوَامِ سَـهْـلَةٌ مُيَسَّرَهْ",
                "Arti : \n\n51. Inilah keterangan Aqidah secara ringkas bagi orang-orang awam yang mudah dan gampang\n\n\n" +
                        "Penjelasan : \n\nInilah akidah yang wajib diyakini oleh seluruh umat Islam. Akidah yang mudah untuk dipahami, " +
                        "diyakini kemudian diamalkan oleh seluruh umat Islam.");


        addProduct("نَاظِمُ تِلْكَ أَحْـمَدُ الْمَرْزُوْقِيْ (52) مَنْ يَنْتَمِي لِلصَّـادِقِ الْمَصْدُوْقِ",
                "Arti : \n\n52. Yang di nadhomkan oleh Ahmad Al Marzuqi, seorang yang bernisbat" +
                        " kepada Nabi Muhammad (As-Shodiqul Mashduq)\n\n\n" +
                        "Penjelasan : \n\nKitab ini disusun oleh Syeikh Ahmad Marzuki yang menerangkan tentang Aqidah (Keimanan), " +
                        "dan telah diringkas dengan rangkaian yang berbentuk nadhom, guna memudahkan terhadap siapa saja yang ingin belajar ilmu tauhid.");


        addProduct("وَ الْحَمْدُ ِللهِ وَصَـلَّى سَـلَّمَا (53) عَلَـى النَّبِيِّ خَيْرِ مَنْ قَدْ عَلَّـمَا",
                "Arti : \n\n53. Dan segala puji bagi Allah serta Sholawat dan Salam tercurahkan" +
                        " kepada Nabi sebaik-baik orang yang telah mengajar\n\n\n" +
                        "Penjelasan : \n\nSetelah Syeikh Ahmad Marzuki selesai menyusun kitab ini, lalu beliau memuji terhadap Allah Subhanahu Wata'ala. " +
                        "dengan ucapan Alhamdulillah dan berdoa semoga sholawat serta salam ditetapkan atas junjungan Nabi Besar Muhammad Salallahualaihi Wasalam");


        addProduct("وَاْلآلِ وَالصَّـحْبِ وَكُلِّ مُرْشِدِ (54) وَكُلِّ مَـنْ بِخَيْرِ هَدْيٍ يَقْتَدِيْ",
                "Arti : \n\n54. Juga kepada keluarga dan sahabat serta orang yang memberi " +
                        "petunjuk dan orang yang mengikuti petunjuk\n\n\n" +
                        "Penjelasan : \n\nbeserta keluarga Nabi, sahabat-sahabat Nabi serta setiap orang yang sama-sama berbuat kebaikan.");


        addProduct("وَأَسْـأَلُ الْكَرِيْمَ إِخْلاَصَ الْعَمَلْ (55) ونَفْعَ كُلِّ مَنْ بِهَا قَدِ اشْـتَغَلْ",
                "Arti : \n\n55. Dan saya mohon kepada Allah yang Maha Pemurah keikhlasan dalam beramal " +
                        "dan manfaat bagi setiap orang yang berpegang teguh pada aqidah ini\n\n\n" +
                        "Penjelasan : \n\nDisamping itu beliau berdo'a semoga amal ini dicatat sebagai amal yang ikhlas dan berguna bagi siapa saja yang mempelajarinya.");


        addProduct("أَبْيَاتُهَا ( مَيْـزٌ ) بِـعَدِّ الْجُمَلِ (56) تَارِيْخُهَا ( لِيْ حَيُّ غُرٍّ ) جُمَلِ",
                "Arti : \n\n56. Nadhom ini ada 57 bait dengan hitungan abjad, tahun penulisannya 1258 Hijriah\n\n\n" +
                        "Penjelasan : \n\nJumlah nadhom dalam kitab ini sebanyak lima puluh tujuh (57), menurut hitungan A ba ja dun dari kata maizun\n" +
                        "\n" +
                        "  40 = م\n" +
                        "    10 =  ي\n" +
                        " 7 = ز\n" +
                        "\n" +
                        "jumlah 57\n" +
                        "\n" +
                        "Sedangkan selesainya kitab ini jatuh pada tahun 1258 juga menurut hitungan A ba ja dun dan kata Ly hayyu ghurrin\n" +
                        "\n" +
                        "  30  =  ل\n" +
                        "10 =  ي\n" +
                        " 8  =  ح\n" +
                        "10 =  ي\n" +
                        "   1000  =  غ\n" +
                        "   200 =  ر\n" +
                        "jumlah = 1258");


        addProduct("سَـمَّيْـتُهَا عَـقِـيْدَةَ الْعَوَامِ (57) مِـنْ وَاجِبٍ فِي الدِّيْنِ بِالتَّمَامِ",
                "Arti : \n\n57. Aku namakan aqidah ini Aqidatul Awwam, keterangan yang wajib " +
                        "diketahui dalam urusan agama dengan sempurna\n\n\n" +
                        "Penjelasan : \n\nSyekh Ahmad Marzuki mengatakan, \"Kitab ini saya beri nama 'Aqidatul Awam', " +
                        "yang memuat tentang sesuatu yang wajib diketahui dan diyakini oleh setiap orang mukalaf dalam masalah agama\"");

    }

    //here we maintain our products in various departments
    private int addProduct(String department, String product) {

        int groupPosition = 0;

        //check the hash map if the group already exists
        GroupInfo headerInfo = subjects.get(department);
        //add the group if doesn't exists
        if (headerInfo == null) {
            headerInfo = new GroupInfo();
            headerInfo.setName(department);
            subjects.put(department, headerInfo);
            deptList.add(headerInfo);
        }

        //get the children for the group
        ArrayList<ChildInfo> productList = headerInfo.getProductList();
        //size of the children list
        int listSize = productList.size();
        //add to the counter
        listSize++;

        //create a new child and add that to the group
        ChildInfo detailInfo = new ChildInfo();
        detailInfo.setSequence(String.valueOf(listSize));
        detailInfo.setName(product);
        productList.add(detailInfo);
        headerInfo.setProductList(productList);

        //find the group position inside the list
        groupPosition = deptList.indexOf(headerInfo);
        return groupPosition;
    }
}
