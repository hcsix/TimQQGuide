package com.supcoder.timqqguide

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v4.view.ViewPager.OnPageChangeListener
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.RadioGroup
import com.airbnb.lottie.LottieComposition
import kotlinx.android.synthetic.main.activity_main.*

/**
 * MainActivity
 *
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initFragment()
        initRadioGroup()
    }


    /**
     * 初始化Fragment
     */
    private fun initFragment() {
        val fragments = ArrayList<Fragment>()
        (0..3).mapTo(fragments) { GuideFragment.getInstance(it) }

        val mFragmentManager = supportFragmentManager

        viewPager.adapter = GuideAdapter(fm = mFragmentManager, fragmentList = fragments)


        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {

                when (position) {
                    0 -> {
                        animationView.cancelAnimation()
                        radio0.isChecked = true
                        playAnim("LottieGuide1/images", "LottieGuide1/data.json")
                    }
                    1 -> {
                        animationView.cancelAnimation()
                        radio1.isChecked = true
                        playAnim("LottieGuide2/images", "LottieGuide2/data.json")
                    }
                    2 -> {
                        animationView.cancelAnimation()
                        radio2.isChecked = true
                        playAnim("LottieGuide3/images", "LottieGuide3/data.json")
                    }
                    3 -> {
                        animationView.cancelAnimation()
                        radio3.isChecked = true
                        playAnim("LottieGuide4/images", "LottieGuide4/data.json")
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })

    }


    private fun initRadioGroup() {
        radio0.isChecked = true
    }


    private fun playAnim(assetName: String, fileName: String) {
        animationView.imageAssetsFolder = assetName
        LottieComposition.Factory.fromAssetFileName(this, fileName, { composition ->
            if (composition == null) {
                onLoadError()
            } else {
                setComposition(composition, assetName)
            }
        })
        animationView.playAnimation()
    }


    private fun onLoadError() {
        Snackbar.make(contentView, "Failed to load animation", Snackbar.LENGTH_LONG).show()
    }


    private fun setComposition(composition: LottieComposition, name: String) {
        if (composition.hasImages() && TextUtils.isEmpty(animationView.imageAssetsFolder)) {
            Snackbar.make(contentView, "This animation has images and no image folder was set", Snackbar.LENGTH_LONG).show()
            return
        }
        animationView.setComposition(composition)
        // make sure the animation doesn't start larger than the screen

    }

}
