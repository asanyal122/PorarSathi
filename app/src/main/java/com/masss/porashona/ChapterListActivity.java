package com.masss.porashona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ChapterListActivity extends AppCompatActivity {
    RecyclerView rcv;
    Integer image_id;
    Integer subject_id;
    Integer class_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_list);

        Intent i=getIntent();
        image_id=i.getIntExtra("subject_image_id",0);
        subject_id=i.getIntExtra("subject_id",0);
        class_id=i.getIntExtra("class_id",0);

        //Toast.makeText(getApplicationContext(),subject_id,Toast.LENGTH_LONG).show();


        rcv=findViewById(R.id.chapter_rcv);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        rcv.setLayoutManager(layoutManager);
        rcv.setAdapter(new ChapterListAdapter(getData(),getApplicationContext()));
    }


    private ArrayList<ChapterItemModel> getData() {
        ArrayList<ChapterItemModel> arr=new ArrayList<>();
        String folder="";


        if(class_id==R.string.class_9)
        {
            if(subject_id==R.string.subphy)
            {

                arr.add(new ChapterItemModel(R.string.porimapb,"class9/phy/porimap/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.bologotib,"class9/phy/bologoti/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.torolobayurchapb,"class9/phy/torolobayurchap/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.arkimidisb,"class9/phy/arkimidis/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.sandrotapristhotan9b,"class9/phy/sandrotapristhotan9/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.barnoulib,"class9/phy/barnouli/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.sthitisthapkota9b,"class9/phy/sthitisthapkota9/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.poromanurgothon9b,"class9/phy/poromanurgothon9/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.molerdharona9b,"class9/phy/molerdharona9/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.drobon9b,"class9/phy/drobon9/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.acid9b,"class9/phy/acid9/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.misronerupadanb,"class9/phy/misronerupadan/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.jolb,"class9/phy/jol/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.karjo9b,"class9/phy/karjo9/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.tapb,"class9/phy/tap/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.sobdo9b,"class9/phy/sobdo9/",R.drawable.ic_thermo));

            }
            else if(subject_id==R.string.sublife)
            {
                arr.add(new ChapterItemModel(R.string.jibonotarboichitrob,"class9/life/jibonotarboichitro/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.joibonub,"class9/life/joibonu/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.cellb,"class9/life/cell/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.kolab,"class9/life/kola/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.manobdehob,"class9/life/manobdeho/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.salokb,"class9/life/salok/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.khonijopusthib,"class9/life/khonijopusthi/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.baspmochonb,"class9/life/baspmochon/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.jolkhonijb,"class9/life/jolkhonij/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.sosonb,"class9/life/soson/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.pustib,"class9/life/pusti/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.songbohonb,"class9/life/songbohon/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.rechonb,"class9/life/rechon/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.jibbidyab,"class9/life/jibbidya/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.poribesotarsompodb,"class9/life/poribesotarsompod/",R.drawable.ic_tree));
            }
            else if(subject_id==R.string.submath)
            {

                arr.add(new ChapterItemModel(R.string.bastabsonkkhab,"class9/math/bastabsonkkha/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.suchokb,"class9/math/suchok/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.lekhochitrob,"class9/math/lekhochitro/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.cordinateb,"class9/math/cordinate/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.roikhiksomikrnb,"class9/math/roikhiksomikrn/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.samantorikerdhormob,"class9/math/samantorikerdhormo/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.bohupodib,"class9/math/bohupodi/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.utpadokb,"class9/math/utpadok/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.vedokb,"class9/math/vedok/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.lavokhotib,"class9/math/lavokhoti/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.rasibigganb,"class9/math/rasibiggan/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.kkhetrofolupopadyab,"class9/math/kkhetrofolupopadya/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.sompaddo91b,"class9/math/sompaddo91/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.sompaddo92b,"class9/math/sompaddo92/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.trivujochoturvujporisimab,"class9/math/trivujochoturvujporisima/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.britterporidhib,"class9/math/britterporidhi/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.somobindu9b,"class9/math/somobindu9/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.britterkkhetrofholb,"class9/math/britterkkhetrofhol/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.sthanakkojemiti91b,"class9/math/sthanakkojemiti91/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.sthanakkojemiti92b,"class9/math/sthanakkojemiti92/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.logb,"class9/math/log/",R.drawable.ic_math));

            }
        }

        else if(class_id==R.string.class_10)
        {
            if(subject_id==R.string.subphy)
            {
                arr.add(new ChapterItemModel(R.string.poribesherjonnovabnab,"class10/phy/poribesherjonnovabna/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.gyaserachoronb,"class10/phy/gyaserachoron/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.rasayonikgononab,"class10/phy/rasayonikgonona/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.taperghotonasomuhob,"class10/phy/taperghotonasomuho/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.alob,"class10/phy/alo/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.cholotoritb,"class10/phy/cholotorit/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.atomnu10b,"class10/phy/atomnu10/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.porjaisaronib,"class10/phy/porjaisaroni/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.somojojibondhonb,"class10/phy/somojojibondhon/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.rasaynikbikriyab,"class10/phy/rasaynikbikriya/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.ojoibob,"class10/phy/ojoibo/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.dhatubidyab,"class10/phy/dhatubidya/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.joibob,"class10/phy/joibo/",R.drawable.ic_thermo));

            }
            else if(subject_id==R.string.sublife)
            {
                arr.add(new ChapterItemModel(R.string.udvidersongbedonshilotab,"class10/life/udvidersongbedonshilota/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.cholonb,"class10/life/cholon/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.hormoneb,"class10/life/hormone/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.nurveb,"class10/life/nurve/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.eyeb,"class10/life/eye/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.gomonb,"class10/life/gomon/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.celldivissionb,"class10/life/celldivission/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.jononb,"class10/life/jonon/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.briddhiobikashb,"class10/life/briddhiobikash/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.bangsogotib,"class10/life/bangsogoti/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.ovibektib,"class10/life/ovibekti/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.ovijojonb,"class10/life/ovijojon/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.poribesb,"class10/life/poribes/",R.drawable.ic_tree));



            }
            else if(subject_id==R.string.submath)
            {
                arr.add(new ChapterItemModel(R.string.dwighatkoronib,"class10/math/dwighatkoroni/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.onupatb,"class10/math/onupat/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.vedb,"class10/math/ved/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.koronib,"class10/math/koroni/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.sorolsudkoshab,"class10/math/sorolsudkosha/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.chakrabridhisudb,"class10/math/chakrabridhisud/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.samaharbridhib,"class10/math/samaharbridhi/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.ongshidarikarbarb,"class10/math/ongshidarikarbar/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.ayotoghonokb,"class10/math/ayotoghonok/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.golokb,"class10/math/golok/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.lombobrittakarchongb,"class10/math/lombobrittakarchong/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.lombobrittakarshonkub,"class10/math/lombobrittakarshonku/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.brittersporshoksongkrantoupopaddob,"class10/math/brittersporshoksongkrantoupopaddo/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.brittosomporkitoupopaddob,"class10/math/brittosomporkitoupopaddo/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.dwighatkoronib,"class10/math/dwighatkoroni/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.brittosthochoturvujsomporkitoupopaddob,"class10/math/brittosthochoturvujsomporkitoupopaddo/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.sompaddoporibrittoontorbrittob,"class10/math/sompaddoporibrittoontorbritto/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.brittersporshoksongkrantoupopaddob,"class10/math/brittersporshoksongkrantoupopaddo/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.sompaddobrittersporshokonkonb,"class10/math/sompaddobrittersporshokonkon/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.sodrishotab,"class10/math/sodrishota/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.ghonobostusongkrantobastobsomosyab,"class10/math/ghonobostusongkrantobastobsomosya/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.trikonmitikonporimapb,"class10/math/trikonmitikonporimap/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.sompaddomodhyosomanupatinirnoyb,"class10/math/sompaddomodhyosomanupatinirnoy/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.pythagoraserupopaddob,"class10/math/pythagoraserupopaddo/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.trikonmitionupatovedb,"class10/math/trikonmitionupatoved/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.purokkonertrikonmitib,"class10/math/purokkonertrikonmiti/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.trikonmitiuchhotadurottob,"class10/math/trikonmitiuchhotadurotto/",R.drawable.ic_math));
                arr.add(new ChapterItemModel(R.string.rasibigganb,"class10/math/rasibiggan/",R.drawable.ic_math));

            }
        }

        else if(class_id==R.string.class_12)
        {
            if(subject_id==R.string.subphysics)
            {
                arr.add(new ChapterItemModel(R.string.sthirtoritb,"class12/phy/sthirtorit/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.toritkhetrob,"class12/phy/toritkhetro/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.toritbivobb,"class12/phy/toritbivob/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.dharokb,"class12/phy/dharok/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.ohomb,"class12/phy/ohom/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.karshopb,"class12/phy/karshop/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.toritsoktiokhomotab,"class12/phy/toritsoktiokhomota/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.chombokkhetrb,"class12/phy/chombokkhetrb/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.chombokdhormob,"class12/phy/chombokdhormo/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.chumbokioabesb,"class12/phy/chumbokioabes/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.acb,"class12/phy/ac/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.emwaveb,"class12/phy/emwave/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.protipholonb,"class12/phy/protipholon/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.protisoronb,"class12/phy/protisoron/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.lensb,"class12/phy/lens/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.bicchurnb,"class12/phy/bicchurn/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.beticharb,"class12/phy/betichar/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.opobortonb,"class12/phy/opoborton/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.quantumb,"class12/phy/quantum/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.atomb,"class12/phy/atom/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.atomnub,"class12/phy/atomnu/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.electronicsb,"class12/phy/electronics/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.digitalb,"class12/phy/digital/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.comb,"class12/phy/com/",R.drawable.ic_thermo));


            }
            else if(subject_id==R.string.subbio)
            {
                arr.add(new ChapterItemModel(R.string.ReproductioninOrganismsb,"class12/bio/ReproductioninOrganisms/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.SexualReproductioninFloweringPlantsb,"class12/bio/SexualReproductioninFloweringPlants/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.HumanReproductionb,"class12/bio/HumanReproduction/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.ReproductiveHealthb,"class12/bio/ReproductiveHealth/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.HeredityandVariationb,"class12/bio/HeredityandVariation/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.MolecularBasisofInheritanceb,"class12/bio/MolecularBasisofInheritance/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.Evolutionb,"class12/bio/Evolution/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.MechanismofEvolutionb,"class12/bio/MechanismofEvolution/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.HealthandDiseasesb,"class12/bio/HealthandDiseases/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.ImprovementinFoodProductionb,"class12/bio/ImprovementinFoodProduction/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.MicrobesinHumanWelfareb,"class12/bio/MicrobesinHumanWelfare/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.BiotechnologyandItsApplicationb,"class12/bio/BiotechnologyandItsApplication/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.EcologyEnvironmentandPopulationb,"class12/bio/EcologyEnvironmentandPopulation/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.Ecosystemb,"class12/bio/Ecosystemb/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.BiodiversityandConservationb,"class12/bio/BiodiversityandConservation/",R.drawable.ic_tree));
                arr.add(new ChapterItemModel(R.string.EnvironmentalIssuesb,"class12/bio/EnvironmentalIssues/",R.drawable.ic_tree));
            }
            else if(subject_id==R.string.subchem)
            {
                arr.add(new ChapterItemModel(R.string.podartherkothinobosthab,"class12/chem/podartherkothinobostha/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.drobonb,"class12/chem/drobon/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.toritrosayanb,"class12/chem/toritrosayan/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.rosayanikgotibiddyab,"class12/chem/rosayanikgotibiddya/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.pristhotliyrsayanb,"class12/chem/pristhotliyrsayan/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.moulerprithokikoronb,"class12/chem/moulerprithokikoron/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.sblockb,"class12/chem/sblock/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.pblockb,"class12/chem/pblock/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.dfblockb,"class12/chem/dfblock/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.jotilb,"class12/chem/jotil/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.heloalkenb,"class12/chem/heloalken/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.alkoholb,"class12/chem/alkohol/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.aldihaidb,"class12/chem/aldihaid/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.nghotitob,"class12/chem/nghotito/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.polimarb,"class12/chem/polimar/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.protyahikjibonerosayonb,"neet/chem/protyahikjibonerosayon/",R.drawable.ic_water_drop));
            }
            else if(subject_id==R.string.submath)
            {

            }
        }

        else if(class_id==R.string.neet)
        {
            if(subject_id==R.string.subphysics)
            {
                arr.add(new ChapterItemModel(R.string.matrab,"neet/phy/matra/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.ekmatrikb,"neet/phy/ekmatrik/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.vectorb,"neet/phy/vectort/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.newtonb,"neet/phy/newton/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.ghorsonb,"neet/phy/ghorson/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.brittiogtib,"neet/phy/brittiogti/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.karjob,"neet/phy/karjo/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.dirobostub,"neet/phy/dirobostu/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.mohakorsob,"neet/phy/mohakorso/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.sthitisthapokotab,"neet/phy/sthitisthapokota/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.udsthitibidyab,"neet/phy/udsthitibidya/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.sandrotaopristotanb,"neet/phy/sandrotaopristotan/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.calorimitib,"neet/phy/calorimiti/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.obostharporibartanb,"neet/phy/obostharporibartan/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.tapsanchalanb,"neet/phy/tapsanchalan/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.gaserprosaronb,"neet/phy/gaserprosaron/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.gasergotiotottob,"neet/phy/gasergotiototto/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.tapgtibidyab,"neet/phy/tapgtibidya/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.shmb,"neet/phy/shm/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.komponotoronggob,"neet/phy/komponotoronggo/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.sthirtoritb,"neet/phy/sthirtorit/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.toritkhetrob,"neet/phy/toritkhetro/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.toritbivobb,"neet/phy/toritbivob/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.dharokb,"neet/phy/dharok/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.ohomb,"neet/phy/ohom/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.karshopb,"neet/phy/karshop/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.toritsoktiokhomotab,"neet/phy/toritsoktiokhomota/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.chombokkhetrb,"neet/phy/chombokkhetrb/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.chombokdhormob,"neet/phy/chombokdhormo/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.chumbokioabesb,"neet/phy/chumbokioabes/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.acb,"neet/phy/ac/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.emwaveb,"neet/phy/emwave/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.protipholonb,"neet/phy/protipholon/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.protisoronb,"neet/phy/protisoron/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.lensb,"neet/phy/lens/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.bicchurnb,"neet/phy/bicchurn/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.beticharb,"neet/phy/betichar/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.opobortonb,"neet/phy/opoborton/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.quantumb,"neet/phy/quantum/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.atomb,"neet/phy/atom/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.atomnub,"neet/phy/atomnu/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.electronicsb,"neet/phy/electronics/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.digitalb,"neet/phy/digital/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.comb,"neet/phy/com/",R.drawable.ic_thermo));



            }
            else if(subject_id==R.string.subbio)
            {
                arr.add(new ChapterItemModel(R.string.sthirtoritb,"neet/bio/sthirtorit/",R.drawable.ic_tree));

            }
            else if(subject_id==R.string.subchem)
            {
                arr.add(new ChapterItemModel(R.string.rosayanbigganb,"neet/chem/rosayanbiggan/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.poromanurgothonb,"neet/chem/poromanurgothon/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.moulogulirsrenib,"neet/chem/moulogulirsreni/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.rosayanikbondhonb,"neet/chem/rosayanikbondhon/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.podarthergyasiyob,"neet/chem/podarthergyasiyo/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.rasayoniktapgotibiddyab,"neet/chem/rasayoniktapgotibiddya/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.samyabosthab,"neet/chem/samyabostha/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.jaronbijaronb,"neet/chem/jaronbijaron/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.h2b,"neet/chem/h2/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.joiborosayanb,"neet/chem/joiborosayan/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.haydrocarbonb,"neet/chem/haydrocarbon/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.poribesorosayanb,"neet/chem/poribesorosayan/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.podartherkothinobosthab,"neet/chem/podartherkothinobostha/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.drobonb,"neet/chem/drobon/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.toritrosayanb,"neet/chem/toritrosayan/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.rosayanikgotibiddyab,"neet/chem/rosayanikgotibiddya/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.pristhotliyrsayanb,"neet/chem/pristhotliyrsayan/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.moulerprithokikoronb,"neet/chem/moulerprithokikoron/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.sblockb,"neet/chem/sblock/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.pblockb,"neet/chem/pblock/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.dfblockb,"neet/chem/dfblock/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.jotilb,"neet/chem/jotil/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.heloalkenb,"neet/chem/heloalken/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.alkoholb,"neet/chem/alkohol/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.aldihaidb,"neet/chem/aldihaid/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.nghotitob,"neet/chem/nghotito/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.polimarb,"neet/chem/polimar/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.protyahikjibonerosayonb,"neet/chem/protyahikjibonerosayon/",R.drawable.ic_water_drop));


            }
        }

        else if(class_id==R.string.bscnur)
        {
            if(subject_id==R.string.subphysics)
            {
                arr.add(new ChapterItemModel(R.string.matrab,"nur/phy/matra/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.ekmatrikb,"nur/phy/ekmatrik/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.vectorb,"nur/phy/vectort/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.newtonb,"nur/phy/newton/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.ghorsonb,"nur/phy/ghorson/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.brittiogtib,"nur/phy/brittiogti/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.karjob,"nur/phy/karjo/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.dirobostub,"nur/phy/dirobostu/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.mohakorsob,"nur/phy/mohakorso/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.sthitisthapokotab,"nur/phy/sthitisthapokota/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.udsthitibidyab,"nur/phy/udsthitibidya/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.sandrotaopristotanb,"nur/phy/sandrotaopristotan/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.calorimitib,"nur/phy/calorimiti/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.obostharporibartanb,"nur/phy/obostharporibartan/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.tapsanchalanb,"nur/phy/tapsanchalan/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.gaserprosaronb,"nur/phy/gaserprosaron/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.gasergotiotottob,"nur/phy/gasergotiototto/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.tapgtibidyab,"nur/phy/tapgtibidya/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.shmb,"nur/phy/shm/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.komponotoronggob,"nur/phy/komponotoronggo/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.sthirtoritb,"nur/phy/sthirtorit/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.toritkhetrob,"nur/phy/toritkhetro/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.toritbivobb,"nur/phy/toritbivob/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.dharokb,"nur/phy/dharok/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.ohomb,"nur/phy/ohom/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.karshopb,"nur/phy/karshop/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.toritsoktiokhomotab,"nur/phy/toritsoktiokhomota/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.chombokkhetrb,"nur/phy/chombokkhetrb/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.chombokdhormob,"nur/phy/chombokdhormo/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.chumbokioabesb,"nur/phy/chumbokioabes/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.acb,"nur/phy/ac/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.emwaveb,"nur/phy/emwave/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.protipholonb,"nur/phy/protipholon/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.protisoronb,"nur/phy/protisoron/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.lensb,"nur/phy/lens/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.bicchurnb,"nur/phy/bicchurn/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.beticharb,"nur/phy/betichar/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.opobortonb,"nur/phy/opoborton/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.quantumb,"nur/phy/quantum/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.atomb,"nur/phy/atom/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.atomnub,"nur/phy/atomnu/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.electronicsb,"nur/phy/electronics/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.digitalb,"nur/phy/digital/",R.drawable.ic_thermo));
                arr.add(new ChapterItemModel(R.string.comb,"nur/phy/com/",R.drawable.ic_thermo));

            }
            else if(subject_id==R.string.subbio)
            {
                arr.add(new ChapterItemModel(R.string.sthirtoritb,"nur/bio/sthirtorit/",R.drawable.ic_tree));

            }
            else if(subject_id==R.string.subchem)
            {
                arr.add(new ChapterItemModel(R.string.rosayanbigganb,"nur/chem/rosayanbiggan/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.poromanurgothonb,"nur/chem/poromanurgothon/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.moulogulirsrenib,"nur/chem/moulogulirsreni/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.rosayanikbondhonb,"nur/chem/rosayanikbondhon/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.podarthergyasiyob,"nur/chem/podarthergyasiyo/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.rasayoniktapgotibiddyab,"nur/chem/rasayoniktapgotibiddya/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.samyabosthab,"nur/chem/samyabostha/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.jaronbijaronb,"nur/chem/jaronbijaron/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.h2b,"nur/chem/h2/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.joiborosayanb,"nur/chem/joiborosayan/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.haydrocarbonb,"nur/chem/haydrocarbon/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.poribesorosayanb,"nur/chem/poribesorosayan/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.podartherkothinobosthab,"nur/chem/podartherkothinobostha/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.drobonb,"nur/chem/drobon/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.toritrosayanb,"nur/chem/toritrosayan/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.rosayanikgotibiddyab,"nur/chem/rosayanikgotibiddya/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.pristhotliyrsayanb,"nur/chem/pristhotliyrsayan/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.moulerprithokikoronb,"nur/chem/moulerprithokikoron/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.sblockb,"nur/chem/sblock/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.pblockb,"nur/chem/pblock/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.dfblockb,"nur/chem/dfblock/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.jotilb,"nur/chem/jotil/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.heloalkenb,"nur/chem/heloalken/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.alkoholb,"nur/chem/alkohol/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.aldihaidb,"nur/chem/aldihaid/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.nghotitob,"nur/chem/nghotito/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.polimarb,"nur/chem/polimar/",R.drawable.ic_water_drop));
                arr.add(new ChapterItemModel(R.string.protyahikjibonerosayonb,"nur/chem/protyahikjibonerosayon/",R.drawable.ic_water_drop));
            }
        }


        return arr;
    }
}