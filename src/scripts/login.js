document.getElementById("colorButton").addEventListener("click", function() {
    var randomColor = '#'+Math.floor(Math.random()*16777215).toString(16);
    document.getElementById("colorButton").style.backgroundColor = randomColor;
  });