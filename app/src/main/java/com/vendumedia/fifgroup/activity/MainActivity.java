package com.vendumedia.fifgroup.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.vendumedia.fifgroup.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.promo_banner_slider) SliderLayout promoBannerSlider;
    @BindView(R.id.promo_banner_slider_indicator) PagerIndicator promoBannerSliderIndicator;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setElevation(0);

        loadBanner();

    }

    @OnClick(R.id.news_info)
    protected void loadNews() {
        Log.i("aldieemaulana", "aldieemaulana click");
        // loadMenu(new Intent(MainActivity.this, NewsInfoActivity.class));
    }

    protected void loadMenu(Intent intent) {
        startActivity(intent);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
    }

    protected void loadBanner() {
        DefaultSliderView slideOne = new DefaultSliderView(MainActivity.this);
        slideOne.image(R.drawable.slide_one)
                .setScaleType(BaseSliderView.ScaleType.CenterInside);
        promoBannerSlider.addSlider(slideOne);

        DefaultSliderView slideTwo = new DefaultSliderView(MainActivity.this);
        slideTwo.image(R.drawable.slide_two)
                .setScaleType(BaseSliderView.ScaleType.CenterInside);
        promoBannerSlider.addSlider(slideTwo);

        promoBannerSlider.setDuration(4000);
        promoBannerSlider.setPresetTransformer(SliderLayout.Transformer.Fade);
        promoBannerSlider.setCustomIndicator(promoBannerSliderIndicator);
    }


}
