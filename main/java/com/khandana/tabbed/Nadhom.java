package com.khandana.tabbed;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;

import com.khandana.tabbed.Settings.BaseActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Nadhom extends BaseActivity {
    List<String> list;
    ListView listView;
    ImageButton play;
    MediaPlayer mp;
    protected void onPause(){
        super.onPause();
        if (mp !=null){
            mp.stop();
            mp.reset();
            mp.release();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nadhom);


        prepareData();

        listView = (ListView) findViewById(R.id.listview);
        play = (ImageButton) findViewById(R.id.play);
        mp = MediaPlayer.create(this, R.raw.pa);
        mp.start();


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()){
                    mp.pause();
                    play.setImageResource(android.R.drawable.ic_media_play);
                } else {
                    mp.start();
                    play.setImageResource(android.R.drawable.ic_media_pause);
                }
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.text_nadhom, list);
        listView.setAdapter(adapter);
    }




    private void prepareData(){
        list = new ArrayList<>();

        list.add("أَبْـدَأُ بِـسْمِ اللهِ وَالرَّحْـمَنِ (1) وَبِالرَّحِـيْـمِ دَائـِمِ اْلإِحْـسَانِ\n" +
                "\n" +
                "Abda u bismillahi warrohmani Wabirrohimi da imil ihsani");

        list.add("فَالْحَـمْـدُ ِللهِ الْـقَدِيْمِ اْلأَوَّلِ (2) اَلآخِـرِ الْبَـاقـِيْ بِلاَ تَحَـوُّلِ\n" +
                "\n" +
                "Falhamdulillahil qodimil awwali Al akhiril baqi bila tahawwuli");

        list.add("ثُمَّ الـصَّلاَةُ وَالسَّلاَمُ سَـرْمَدَا (3) عَلَى الـنَّـبِيِّ خَيْرِ مَنْ قَدْ وَحَّدَا\n" +
                "\n" +
                "Tsummasholatu wassalamu sarmada ‘alannabiyyi khoiri man qod wahhada");

        list.add("وَآلِهِ وَصَـحْبِهِ وَمَـنْ تَـبِـعْ (4) سَـبِيْلَ دِيْنِ الْحَقِّ غَيْرَ مُـبْـتَدِعْ\n" +
                "\n" +
                "Wa alihi washohbihi waman tabi’ Sabila dinil haqqi qhoiro mubtadi’\n");

        list.add("وََبَعْدُ فَاعْلَمْ بِوُجُوْبِ الْمَعْرِفَـهْ (5) مِنْ وَاجِـبٍ ِللهِ عِشْـرِيْنَ صِفَهْ\n" +
                "\n" +
                "Waba’du fa’lam biwujubil ma’rifah Min wajibin lillahi ‘isyrina sifah");

        list.add("َفَاللهُ مَوْجُـوْدٌ قَـدِيْمٌ بَاقِـي (6) مُخَالـِفٌ لِلْـخَـلْقِ بِاْلإِطْلاَقِ\n" +
                "\n" +
                "Fallohi maujudun qodimun baqi Mukholifun lilkholqi bil ithlaqi");

        list.add("وََقَـائِمٌ غَـنِيْ وَوَاحِـدٌ وَحَيّ (7) قَـادِرْ مُـرِيْـدٌ عَـالِمٌ بِكُلِّ شَيْ\n" +
                "\n" +
                "Wa qooimun ghoni wa wahidun wahai Qodir muridun ‘aalimun bikulli syai");

        list.add("سَـمِـيْعٌ اْلبَصِـيْرُ وَالْمُتَكَلِّـمُ (8) لَهُ صِـفَاتٌ سَـبْعَـةٌ تَـنْـتَظِمُ\n" +
                "\n" +
                "Sami’unil bashiru wal mutakallimu Lahu shifatun sa’atun tantadzimu");

        list.add("فقُـدْرَةٌ إِرَادَةٌ سـَمْـعٌ بـَصَرْ (9) حَـيَـاةٌ الْعِلْـمُ كَلاَمٌ اسْـتَمَرْ\n" +
                "\n" +
                "Faqudrotun iroodatun sam’un bashor Hayatunil ‘ilmu kalamunistamar");

        list.add("وََجَائـِزٌ بِـفَـضْـلِهِ وَ عَدْلِهِ (10) تَـرْكٌ لـِكُلِّ مُمْـكِـنٍ كَفِعْلِهِ\n" +
                "\n" +
                "Wajaizun bifadlihi wa ‘adlihi Tarkun likulli mumkinin kafi’lihi");

        list.add("أََرْسَـلَ أَنْبِيَا ذَوِي فَـطَـانَـهْ (11) بِالصِّـدْقِ وَالتَـبْلِـيْغِ وَاْلأَمَانَهْ\n" +
                "\n" +
                "Arsala anbiya dzawil fathonah Bisshidqi wattablighi wal amanah");

        list.add("وَجَـائِزٌ فِي حَـقِّهِمْ مِنْ عَرَضِ (12) بِغَيْـرِ نَقْصٍ كَخَـفِيْفِ الْمَرَضِ\n" +
                "\n" +
                "Wa jaaizun fi haqqihim mim ‘arodhi Bighoiri naqsin kakhofifil marodhi");

        list.add("عِصْـمَـتُهُمْ كَسَائِرِ الْمَلاَئِكَهْ (13) وَاجِـبَـةٌ وَفَاضَلُوا الْمَـلاَئِكَهْ\n" +
                "\n" +
                "‘Ismatuhum ka saairil malaikah Wajibatun wafaadholul malaikah");

        list.add("وََالْمُسْـتَحِيْلُ ضِدُّ كُلِّ وَاجِبِ (14) فَاحْفَظْ لِخَمْسِـيْنَ بِحُكْمٍ وَاجِبِ\n" +
                "\n" +
                "Walmustahilu dhiddu kulli wajibi Fahfadz likhomsina bi hukmin wajibi");

        list.add("تَفْصِيْلُ خَمْسَةٍ وَعِشْـرِيْنَ لَزِمْ (15) كُـلَّ مُـكَلَّـفٍ فَحَقِّقْ وَاغْـتَنِمْ\n" +
                "\n" +
                "Tafsilu khomsatin wa ‘isyrina lazim kulla mukallafin fahaqqiq waghtanim");

        list.add("هُمْ آدَمٌ اِدْرِيْسُ نُوْحٌ هُـوْدُ مَعْ (16)  صَالِـحْ وَإِبْرَاهِـيْـمُ كُلٌّ مُـتَّبَعْ\n" +
                "\n" +
                "Hum Adamun Idrisu Nuhun Hudun ma’ Sholih wa Ibrihiimu kullun muttaba’");

        list.add("لُوْطٌ وَاِسْـمَاعِيْلُ اِسْحَاقُ كَذَا (17) يَعْقُوبُ يُوسُـفُ وَأَيُّوْبُ احْتَذَى\n" +
                "\n" +
                "Luthun wa isma’ilu Ishaqun kadza Ya’quubu Yuusufu wa Ayyubuh tadza");

        list.add("شُعَيْبُ هَارُوْنُ وَمُوْسَى وَالْيَسَعْ (18) ذُو الْكِـفْلِ دَاوُدُ سُلَيْمَانُ اتَّـبَعْ\n" +
                "\n" +
                "Syu’aibu Haruna wa Musa Walyasa’ Dzulkifli Dawudu Sulaimanuttaba’");

        list.add("إلْيَـاسُ يُوْنُسْ زَكَرِيـَّا يَحْيَى (19) عِيْسَـى وَطَـهَ خَاتِمٌ دَعْ غَـيَّا\n" +
                "\n" +
                "Ilyaasu Yuunusu Zakariya Yahya ‘Iisa wa thoha khotimun da’ ghoyya");

        list.add("عَلَـيْهِمُ الصَّـلاَةُ وَالسَّـلاَمُ (20) وَآلِـهِمْ مـَا دَامَـتِ اْلأَيـَّـامُ\n" +
                "\n" +
                "‘Alaihimushollatu wassalamu Wa alihim masdamatil ayyamu");

        list.add("وَالْمَـلَكُ الَّـذِيْ بِلاَ أَبٍ وَأُمْ (21) لاَ أَكْلَ لاَ شُـرْبَ وَلاَ نَوْمَ لَـهُمْ\n" +
                "\n" +
                "Walmalakulladzi bila Abin wa Um La akla laa syurba wala nauma lahum");

        list.add("تَفْـصِـيْلُ عَشْرٍ مِنْهُمُ جِبْرِيْلُ (22) مِـيْـكَـالُ اِسْـرَافِيْلُ عِزْرَائِيْلُ\n" +
                "\n" +
                "Tafshilu ‘asyrin minhuma Jibrilu Mikalu Isrofilu ‘Izroo ilu");

        list.add("مُنْـكَرْ نَكِـيْرٌ وَرَقِيْبٌ وَكَذَا (23) عَتِـيْدٌ مَالِكٌ ورِضْوَانُ احْتَـذَى\n" +
                "\n" +
                "Munkar Nakirun wa Roqibun wakadza ‘Atidun Maalikun wa Ridlwanuhtadza");

        list.add("أَرْبَـعَـةٌ مِنْ كُتُبٍ تَـفْصِيْلُهَا (24) تَوْارَةُ مُوْسَى بِالْهُدَى تَـنْـزِيْلُهَا\n" +
                "\n" +
                "Arba’atun min kutubin tafsiluha Taurotu Musa bil huda tanziluha");

        list.add("زَبُـوْرُ دَاوُدَ وَاِنْجِـيْـلُ عَلَى (25) عِيْـسَى وَفُـرْقَانُ عَلَى خَيْرِ الْمَلاَ\n" +
                "\n" +
                "Zaburu Dawuda wa Injlu ‘ala ‘Isa wa Furqonun ‘ala khoiril mala");

        list.add("وَصُحُـفُ الْخَـلِيْلِ وَالْكَلِيْمِ (26) فِيْهَـا كَلاَمُ الْـحَـكَمِ الْعَلِـيْمِ\n" +
                "\n" +
                "Wa Suhuful kholili walkalimi Fiha kalamul hakamil ‘aliimi");

        list.add("وَكُـلُّ مَا أَتَى بِهِ الـرَّسُـوْلُ (27) فَحَـقُّـهُ التَّسْـلِـيْمُ وَالْقَبُوْلُ\n" +
                "\n" +
                "Wakullu ma ataa bihirRosulu Fahaqquhuttasliimu wal qobuulu");

        list.add("إِيْـمَـانُنَا بِـيَوْمِ آخِرٍ وَجَبْ (28) وَكُلِّ مَـا كَانَ بِـهِ مِنَ الْعَجَبْ\n" +
                "\n" +
                "Imanunaa bi yaumin aakhirin wajab Wakullu maa kana bihi minal ‘ajab");

        list.add("خَاتِمَةٌ فِي ذِكْرِ بَاقِي الْوَاجِبِ (29) مِمَّـا عَـلَى مُكَلَّفٍ مِنْ وَاجِبِ\n" +
                "\n" +
                "Khotimatun fi dzikri baaqil wajibi Mimma ‘ala mukallafin min wajibi");

        list.add("نَبِـيُّـنَا مُحَمَّدٌ قَدْ أُرْسِــلاَ (30) لِلْـعَالَمِـيْـنَ رَحْـمَةً وَفُضِّلاَ\n" +
                "\n" +
                "Nabiyyuna Muhammadun qod ursila Lil’alamiina rohmatan wa fuddhila");

        list.add("أَبـُوْهُ عَبْدُ اللهِ عَبْدُ الْمُطَّلِـبْ (31) وَهَاشِـمٌ عَبْدُ مَنَافٍ يَنْتَسِـبْ\n" +
                "\n" +
                "Abuhu ‘Abdullahi ‘Abdul Muttholib Wa Hasyimun ‘Abdi Manafi yantasib");

        list.add("وَأُمُّـهُ آمِـنَةُ الـزُّهْــرِيـَّهْ (32) أَرْضَـعَتْهُ حَلِيْمَـةُ السَّـعْدِيـَّهْ\n" +
                "\n" +
                "Wa ummuhu Aminatuz Zuhriyyah Ardho’athu Halimatus Sa’diyah");

        list.add("مَوْلـِدُهُ بِمَـكَّـةَ اْلأَمِيْــنَهْ (33) وَفَاتُـهُ بِـطَـيْـبَةَ الْـمَدِيْنَهْ\n" +
                "\n" +
                "Mauliduhu bi Makkatal Aminah Wafatuhu bi thoybatal Madinah");

        list.add("أَتَـمَّ قَـبْـلَ الْـوَحْيِ أَرْبَعِيْنَا (34) وَعُـمْـرُهُ قَدْ جَاوَزَ السِّـتِّيْنَا\n" +
                "\n" +
                "Atamma qoblal wahyi arba’iina Wa ‘umruhu qod jawazas sittiina");

        list.add("وَسَـبْـعَةٌ أَوْلاَدُهُ فَمِـنْـهُمُ (35) ثَلاثَـةٌ مِـنَ الذُّكـُوْرِ تُـفْهَمُ\n" +
                "\n" +
                "Wasab’atun auladuhu faminhumu Tsalasatun minaddzukuuri tufhamu");

        list.add("قَاسِـمْ وَعَبْدُ اللهِ وَهْوَ الطَّيِّبُ (36) وَطَاهِـرٌ بِذَيْـنِ ذَا يُـلَـقَّبُ\n" +
                "\n" +
                "Qasim wa’ Abdullahi wahuwatthoyyibu Wa thohirun bi dzaini dza yulaqqobu");

        list.add("أَتَاهُ إبْرَاهِـيْـمُ مِنْ سُـرِّيـَّهْ (37) فَأُمُّـهُ مَارِيَّةُ الْـقِـبْـطِـيَّـهْ\n" +
                "\n" +
                "Atahu Ibrohimu min sariyah Fa Ummuhu Mariyyaul Qibtiyah");

        list.add("وَغَيْـرُ إِبْرَاهِيْمَ مِنْ خَـدِيْجَهْ (38) هُمْ سِتَـةٌ فَخُـذْ بِهِمْ وَلِـيْجَهْ\n" +
                "\n" +
                "Wa ghoiru Ibrohima min Khodijah Hum sittatun fakhudz bi him wa liijah");

        list.add("وَأَرْبَعٌ مِـنَ اْلإِنَاثِ تُـذْكَـرُ (39) رِضْـوَانُ رَبِّي لِلْجَمِـيْعِ يُذْكَرُ\n" +
                "\n" +
                "Wa arba’un minal inasi tudzkaru Ridlwaanu Robbi lil jami’i yudzkaru");

        list.add("فَاطِـمَـةُ الزَّهْرَاءُ بَعْلُهَا عَلِيْ (40) وَابْنَاهُمَا السِّـبْطَانِ فَضْلُهُمُ جَلِيْ\n" +
                "\n" +
                "Fatimatuz Zahroo u ba’luha ‘Ali Wabna hummassibthoni fadluhum jali");

        list.add("فَزَيْـنَبٌ وَبَعْـدَهَـا رُقَـيَّهْ (41) وَأُمُّ كُـلْـثُـومٍ زَكَـتْ رَضِيَّهْ\n" +
                "\n" +
                "Fa Zainabun wa ba’daha Ruqoyyah Wa Ummu Kultsumin zakat Rodliyah");

        list.add("عَنْ تِسْعِ نِسْوَةٍ وَفَاةُ الْمُصْطَفَى (42) خُيِّـرْنَ فَاخْتَرْنَ النَّـبِيَّ الْمُقْتَفَى\n" +
                "\n" +
                "‘An tis’iniswatin wafaatul Mushthofa Khuyyirna fakhtarnan Nabiyyil muqtafa");

        list.add("عَائِشَـةٌ وَحَفْصَـةٌ وَسَـوْدَةُ (43) صَـفِيَّـةٌ مَـيْـمُـوْنَةٌ وَ رَمْلَةُ\n" +
                "\n" +
                "Aisyatun wa Hafshotun wa Saudah Sofiyyatun Maimunatun wa Romalah");

        list.add("هِنْدٌ وَ زَيْـنَبٌ كَذَا جُوَيـْرِيَهْ (44) لِلْمُـؤْمِـنِيْنَ أُمَّـهَاتٌ مَرْضِـيَّهْ\n" +
                "\n" +
                "Hindun wa Zainabun kadza Juwairiyyah Lil mu’miniina Ummahaatun Mardliyah");

        list.add("حَمْـزَةُ عَمُّـهُ وعَـبَّاسٌ كَذَا (45) عَمَّـتُـهُ صَـفِيَّـةٌ ذَاتُ احْتِذَا\n" +
                "\n" +
                "Hamzatu ‘ummuhu wa ‘Abbasun kadza ‘Ammatuhu Shofiyyatun dza tuhtidza");

        list.add("وَقَبْـلَ هِجْـرَةِ النَّـبِيِّ اْلإِسْرَا (46) مِـنْ مَـكَّةَ لَيْلاً لِقُدْسٍ يُدْرَى\n" +
                "\n" +
                "Wa qobla hijrotin Nabiyyil isroo Min Makkatin lailan li Qudsin yudroo");

        list.add("وَبَعْدَ إِسْـرَاءٍ عُرُوْجٌ لِلسَّـمَا (47) حَتَّى رَأَى النَّـبِيُّ رَبًّـا كَـلَّمَا\n" +
                "\n" +
                "Wa ba’da isroo in ‘urujun lissama Hatta ro an Nabiyyu Robban kallama");

        list.add("مِنْ غَيْرِكَيْفٍ وَانْحِصَارٍ وَافْـتَرَضْ (48) عَلَيْهِ خَمْسًا بَعْدَ خَمْسِيْنَ فَرَضْ\n" +
                "\n" +
                "Min ghoiri kaifin wan hishorin waf tarod ‘Alaihi khomsan ba’da khomsiina farod");

        list.add("وَبَـلَّـغَ اْلأُمَّـةَ بِاْلإِسْــرَاءِ (49) وَفَـرْضِ خَـمْـسَةٍ بِلاَ امْتِرَاءِ\n" +
                "\n" +
                "Waballaqhol ummata bil isroo i Wa fardli khomsatin bi lam tiroo i");

        list.add("قَدْ فَازَ صِـدِّيْقٌ بِتَصْـدِيْقٍ لَهُ (50) وَبِالْعُرُوْجِ الصِّـدْقُ وَافَى أَهْلَهُ\n" +
                "\n" +
                "Qod faaza siddiiqun bi tashdiqin lahu Wa bil ‘Urujis shidqu wafa ahlahu");

        list.add("وَهَـذِهِ عَقِيْـدَةٌ مُخْـتَصَرَهْ (51) وَلِلْـعَـوَامِ سَـهْـلَةٌ مُيَسَّرَهْ\n" +
                "\n" +
                "Wa hadzihi ‘aqidatun mukhtashoroh Wa lil ‘awami sahlatun muyassaroh");

        list.add("نَاظِمُ تِلْكَ أَحْـمَدُ الْمَرْزُوْقِيْ (52) مَنْ يَنْتَمِي لِلصَّـادِقِ الْمَصْدُوْقِ\n" +
                "\n" +
                "Nadzimu tilka Ahmadul Marzuki Mayyantamii lisshoodiqil masduqi");

        list.add("وَ الْحَمْدُ ِللهِ وَصَـلَّى سَـلَّمَا (53) عَلَـى النَّبِيِّ خَيْرِ مَنْ قَدْ عَلَّـمَا\n" +
                "\n" +
                "Walhamdu lillahi wa sholla sallama ‘AlanNabiyyi khoiriman qod ‘allama");

        list.add("وَاْلآلِ وَالصَّـحْبِ وَكُلِّ مُرْشِدِ (54) وَكُلِّ مَـنْ بِخَيْرِ هَدْيٍ يَقْتَدِيْ\n" +
                "\n" +
                "Wal ali wasshohbi wa kulli mursyidi Wakulli man bighoiri hadyin yaqtadi");

        list.add("وَأَسْـأَلُ الْكَرِيْمَ إِخْلاَصَ الْعَمَلْ (55) ونَفْعَ كُلِّ مَنْ بِهَا قَدِ اشْـتَغَلْ\n" +
                "\n" +
                "Wa asalul karima ikhlashol ‘amal Wa naf’a kulliman bihaa qodisytaghol");

        list.add("أَبْيَاتُهَا ( مَيْـزٌ ) بِـعَدِّ الْجُمَلِ (56) تَارِيْخُهَا ( لِيْ حَيُّ غُرٍّ ) جُمَلِ\n" +
                "\n" +
                "Abyatuhaa maizun bi ‘addil jumali Tariikhuhaa lii hayyu ghurrin jumali");

        list.add("سَـمَّيْـتُهَا عَـقِـيْدَةَ الْعَوَامِ (57) مِـنْ وَاجِبٍ فِي الدِّيْنِ بِالتَّمَامِ\n" +
                "\n" +
                "Sammaituha ‘aqidatal ‘awaami Min wajibin fiddiini bittamami");

    }

}
