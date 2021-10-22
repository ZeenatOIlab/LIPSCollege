package com.lipscollage.Activities

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.lipscollage.Adapters.NoticeBoardAdapter
import com.lipscollage.Models.NoticeBoardModel
import com.lipscollage.R
import com.lipscollage.Utility.SetCustomActionBar


class NoticeBoardActivity : AppCompatActivity() {
    lateinit var progressDialog: AlertDialog
    lateinit var activity:NoticeBoardActivity
    lateinit var noticeboard_RecyclerView:RecyclerView
    lateinit var noticeBoardAdapter: NoticeBoardAdapter
    lateinit var noticeList: MutableList<NoticeBoardModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_board)
        var customactionbarObj= SetCustomActionBar()
        activity=this@NoticeBoardActivity
        customactionbarObj.setCustomBar(activity,"Notice Board","notice_board")
        initView()
        initRecyclerView()
    }
    private fun initView()
    {
        noticeboard_RecyclerView=findViewById(R.id.noticeboardRecyclerView)
    }
    private fun initRecyclerView()
    {
        noticeBoardData()
        // Removes blinks
        // Removes blinks
     //   (noticeboard_RecyclerView.getItemAnimator() as SimpleItemAnimator).supportsChangeAnimations = false

        noticeboard_RecyclerView.layoutManager= LinearLayoutManager(activity)
        noticeBoardAdapter= NoticeBoardAdapter(activity,noticeList)
        noticeboard_RecyclerView.adapter=noticeBoardAdapter
        noticeboard_RecyclerView.setHasFixedSize(true);

        noticeBoardAdapter.setOnClickListner(object : NoticeBoardAdapter.OnItemClickListner{
            override fun onItemClickListner(pos: Int) {

            }

        })
    }
    private fun noticeBoardData()
    {
        noticeList= mutableListOf()
        var model1=NoticeBoardModel()

        model1.noticeBoardTitle="Notice Board Tittel 1"
        model1.noticeBoardDate="2021-10-21"
        model1.noticeBoardDescription="Paragraphs are the building blocks of papers. Many students define paragraphs in terms of length: a paragraph is a group of at least five sentences, a paragraph is half a page long, etc. In reality, though, the unity and coherence of ideas among sentences is what constitutes a paragraph. A paragraph is defined as “a group of sentences or a single sentence that forms a unit” (Lunsford and Connors 116). Length and appearance do not determine whether a section in a paper is a paragraph. For instance, in some styles of writing, particularly journalistic styles, a paragraph can be just one sentence long. Ultimately, a paragraph is a sentence or group of sentences that support one main idea. In this handout, we will refer to this as the “controlling idea,” because it controls what happens in the rest of the paragraph."
        noticeList.add(model1)

        var model2=NoticeBoardModel()
        model2.noticeBoardTitle="Notice Board Tittel 2"
        model2.noticeBoardDate="2021-10-22"
        model2.noticeBoardDescription="Paragraphs are the building blocks of papers. Many students define paragraphs in terms of length: a paragraph is a group of at least five sentences, a paragraph is half a page long, etc. In reality, though, the unity and coherence of ideas among sentences is what constitutes a paragraph. A paragraph is defined as “a group of sentences or a single sentence that forms a unit” (Lunsford and Connors 116). Length and appearance do not determine whether a section in a paper is a paragraph. For instance, in some styles of writing, particularly journalistic styles, a paragraph can be just one sentence long. Ultimately, a paragraph is a sentence or group of sentences that support one main idea. In this handout, we will refer to this as the “controlling idea,” because it controls what happens in the rest of the paragraph."
        noticeList.add(model2)

        var model3=NoticeBoardModel()
        model3.noticeBoardTitle="Notice Board Tittel 3"
        model3.noticeBoardDate="2021-10-21"
        model3.noticeBoardDescription="Paragraphs are the building blocks of papers. Many students define paragraphs in terms of length: a paragraph is a group of at least five sentences, a paragraph is half a page long, etc. In reality, though, the unity and coherence of ideas among sentences is what constitutes a paragraph. A paragraph is defined as “a group of sentences or a single sentence that forms a unit” (Lunsford and Connors 116). Length and appearance do not determine whether a section in a paper is a paragraph. For instance, in some styles of writing, particularly journalistic styles, a paragraph can be just one sentence long. Ultimately, a paragraph is a sentence or group of sentences that support one main idea. In this handout, we will refer to this as the “controlling idea,” because it controls what happens in the rest of the paragraph."
        noticeList.add(model3)

    }
}