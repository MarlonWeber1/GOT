package com.example.got.view.detalhes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.got.R
import com.example.got.databinding.ActivityCharacterInfoBinding
import com.example.got.model.Character
import com.example.got.utils.loadImage
import com.example.got.view.EditActivity

class CharacterInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterInfoBinding
    private lateinit var btnEdit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getParcelableExtra<Character>("sendCharacter")

        binding.characterDetailsImage.loadImage(result?.imageUrl)

        binding.completeName.text = result?.fullName
        binding.infoFisrtNameText.text = result?.firstName
        binding.infoTextSecondName.text = result?.lastName
        binding.infoTitle.text = result?.title
        binding.infoFamily.text = result?.family

        btnEdit = findViewById(R.id.button_info_activity)
        btnEdit.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }
    }
}