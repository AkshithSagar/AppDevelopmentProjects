package com.example.viewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class MyPagerAdapter(var mContext: Context): PagerAdapter() {
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var modelCourse = ModelCourse.values()[position]
        var inflater = LayoutInflater.from(mContext)
        var viewGroup = inflater.inflate(modelCourse.layoutID,container,false)
        container.addView(viewGroup)
        return viewGroup
    }

//    override fun destroyItem(container: View, position: Int, `object`: Any) {
//        container.remove
//    }

    override fun getCount(): Int {
        return ModelCourse.values().size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var customPagerEnum:ModelCourse = ModelCourse.values()[position]
        return mContext.getString(customPagerEnum.titleID)
    }

}