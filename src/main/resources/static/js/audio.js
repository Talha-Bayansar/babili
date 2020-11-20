const recordButton = document.getElementById('rec');
const inleveringButton = document.getElementById('inlevering');
const stopButton = document.getElementById('stop');
const playButton = document.getElementById('play');
let mic, recorder, soundFile;
var fft;
var w;


function setup() {
    cnv = createCanvas(200, 200);
    cnv.position(recordButton.offsetLeft, recordButton.offsetTop);
    cnv.hide();
    stopButton.style.display = 'none';
    playButton.style.display = 'none';
    inleveringButton.style.display = 'none';
    colorMode(HSB);
    mic = new p5.AudioIn();
    fft = new p5.FFT(0.7, 64);
    fft.setInput(mic);

    // prompts user to enable their browser mic
    mic.start();

    // create a sound recorder
    recorder = new p5.SoundRecorder();

    // connect the mic to the recorder
    recorder.setInput(mic);

    // this sound file will be used to
    // playback & save the recording
    soundFile = new p5.SoundFile();
    w = 350 / 64;
}

function draw() {
    background('rgba(241, 202, 0, 1)');
    var spectrum = fft.analyze();
    //console.log(spectrum);
    noStroke();
    for (var i = 0; i < spectrum.length; i++) {
        var amp = spectrum[i];
        var y = map(amp, 0, 256, height, 0);
        fill(i, 255, 255);
        rect(i * w, y, w - 2, height - y);
    }
};

recordButton.addEventListener('click', () => {
    recordButton.style.display = 'none';
    cnv.show();
    stopButton.style.display = 'block';
    stopButton.style.marginLeft = 210 + 'px';
    inleveringButton.style.marginTop = 170 + 'px';
    userStartAudio();
    if (mic.enabled) {
        recorder.record(soundFile);
    }
});

stopButton.addEventListener('click', () => {
    recorder.stop();
    mic.stop();
    stopButton.style.display = 'none';
    playButton.style.display = 'block';
    playButton.style.marginLeft = 210 + 'px';
    inleveringButton.style.display = 'block';

});

playButton.addEventListener('click', () => {
    fft.setInput(soundFile);
    soundFile.play();
});



const testOnUserController = async function () {
    console.log("test");
    try {
        const form = new FormData(document.getElementById('soundUpload'));
        if (soundFile.getBlob() == null) console.log('soundfile is null');
        form.append("audioFile", soundFile.getBlob());//error: soundFile is not a blob
        form.append("index", 55);
        let r = await fetch('/user/soundUpload', {method: "POST",  body: form});
        console.log('HTTP response code:', r.status);
    } catch (e) {
        console.log('Huston we have problem...:', e);
    }

}
