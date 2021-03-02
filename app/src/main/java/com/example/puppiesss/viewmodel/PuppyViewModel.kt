package com.example.puppiesss.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.puppiesss.R
import com.example.puppiesss.model.Puppy

class PuppyViewModel: ViewModel() {
    private val _puppies = MutableLiveData<ArrayList<Puppy>>()
    val puppies: LiveData<ArrayList<Puppy>> = _puppies

    fun fetchPuppies() {
        _puppies.value = arrayListOf(
            Puppy(1,"Pug", "The pug is a breed of dog with physically distinctive features of a wrinkly, short-muzzled face, and curled tail. The breed has a fine, glossy coat that comes in a variety of colours, most often light brown or black, and a compact, square body with well-developed muscles.", R.drawable.pug),
            Puppy(2, "Husky", "The Siberian Husky is a medium-sized working sled dog breed. The breed belongs to the Spitz genetic family. It is recognizable by its thickly furred double coat, erect triangular ears, and distinctive markings, and is smaller than the similar-looking Alaskan Malamute.", R.drawable.husky),
            Puppy(3, "Pit pull", "The American Pit Bull Terrier is a dog breed recognized by the United Kennel Club and the American Dog Breeders Association, but not the American Kennel Club. It is a medium-sized, intelligent, short-haired dog, of a solid build, whose early ancestors came from the British Isles.", R.drawable.pitpull),
            Puppy(4, "Shiba Inu", "The Shiba Inu is a breed of hunting dog from Japan. A small-to-medium breed, it is the smallest of the six original and distinct spitz breeds of dog native to Japan. A small, alert and agile dog that copes very well with mountainous terrain and hiking trails, the Shiba Inu was originally bred for hunting.", R.drawable.shiba_inu),
            Puppy(5, "Poodle", "The Poodle is a dog breed that comes in three varieties: Standard Poodle, Miniature Poodle, and Toy Poodle. The breed’s origin is disputed: whether it descends from Germany as a type of water dog, or from the French Barbet.", R.drawable.poodle),
            Puppy(6, "Eskimo", "The American Eskimo Dog is a breed of companion dog, originating in Germany. The American Eskimo Dog is a member of the Spitz family. The breed's progenitors were German Spitz, but due to anti-German sentiment during the First World War, it was renamed American Eskimo Dog.", R.drawable.eskimo),
            Puppy(7, "Iceland", "The Icelandic Sheepdog is a breed of dog of spitz type originating from the dogs brought to Iceland by the Vikings. It is of similar type to the Norwegian Buhund, the Shetland Sheepdog, and the Welsh Corgi. They are commonly used to herd sheep in the Icelandic countryside.", R.drawable.iceland),
            Puppy(8, "Finnish Spizt", "The Finnish Spitz is a breed of dog originating in Finland. The breed was originally bred to hunt all types of game from squirrels and other rodents to bears.", R.drawable.finnish_spizt),
            Puppy(9, "Beagle", "The beagle is a breed of small hound that is similar in appearance to the much larger foxhound. The beagle is a scent hound, developed primarily for hunting hare.", R.drawable.beagle),
            Puppy(10, "Golden Ritriever", "The Golden Retriever is a medium-large gun dog that was bred to retrieve shot waterfowl, such as ducks and upland game birds, during hunting and shooting parties. The name retriever refers to the breed's ability to retrieve shot game undamaged due to their soft mouth.", R.drawable.golden_ritriever)
        )
    }

    fun getPuppy(id: Int): Puppy? {
        puppies.value?.forEach {
            if (it.id == id)
                return it
        }
        return null
    }
}