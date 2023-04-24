package com.axa.tests;

import com.axa.pages.HomePage;
import com.axa.pages.LoginPage;
import com.axa.pages.SubscribtionPage;
import com.axa.pages.RfqListPage;
import com.axa.utilities.PropertyFileSetup;
import com.axa.utilities.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class CreateQuotation extends BaseTest {

    @Test()
    public void EgyptSubcribtion() throws Exception {
        SubscribtionPage subscribtionPage=new SubscribtionPage(this.driver);
        subscribtionPage.selectCounty("eg");
        //subscribtionPage.selectCounty("ae");
       String sEGLightPack=subscribtionPage.GetPackagePrice("currency-لايت");
       String sEGBasicPack=subscribtionPage.GetPackagePrice("currency-الأساسية");
       String sEGPremiumPack=subscribtionPage.GetPackagePrice("currency-بريميوم");

       if (sEGLightPack == "0.25 دولار أمريكي/شهر" && sEGBasicPack =="0.5 دولار أمريكي/شهر" && sEGPremiumPack =="1 دولار أمريكي/شهر")
            assert(true);
       else
           assert (false);
    }

    @Test()
    public void SASubcribtion() throws Exception {
        SubscribtionPage subscribtionPage=new SubscribtionPage(this.driver);
        subscribtionPage.selectCounty("eg");
        //subscribtionPage.selectCounty("ae");
        String sEGLightPack=subscribtionPage.GetPackagePrice("currency-لايت");
        String sEGBasicPack=subscribtionPage.GetPackagePrice("currency-الأساسية");
        String sEGPremiumPack=subscribtionPage.GetPackagePrice("currency-بريميوم");

        if (sEGLightPack == "NA" && sEGBasicPack =="NA" && sEGPremiumPack =="NA")
            assert(true);
        else
            assert (false);
    }


}