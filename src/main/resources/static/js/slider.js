let slider = document.getElementById("ratingSlider")
let bar = document.getElementById("ratingBar")
let text = document.getElementById("ratingText")

function changeTextAndBar(){
    bar.ariaValueNow = slider.value
    bar.style.width = (bar.ariaValueNow / bar.ariaValueMax * 100) + "%"

    text.innerHTML = (+slider.value+1) + ": "

    if (slider.value == 0){
        text.innerHTML += "heel gemakkelijk"
        bar.style.backgroundColor = "transparent"
    } else if(slider.value == 1){
        text.innerHTML += "gemakkelijk"
        bar.style.backgroundColor = "limegreen"
    } else if(slider.value == 2){
        text.innerHTML += "gewoon"
        bar.style.backgroundColor = "yellow"
    } else if (slider.value == 3){
        text.innerHTML += "moeilijk"
        bar.style.backgroundColor = "orange"
    } else {
        text.innerHTML += "heel moeilijk"
        bar.style.backgroundColor = "red"
    }
}

bar.setAttribute("aria-valuemin", slider.min)
bar.setAttribute("aria-valuemax", slider.max)
changeTextAndBar()

slider.addEventListener("input", changeTextAndBar);