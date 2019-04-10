function songUpdateHandler() {
  //============================
  let song_id = document.getElementById('song_id_field').value
  let song_title = document.getElementById('song_title_field').value
  let song_composer = document.getElementById('song_composer_field').value
  let song_key = document.getElementById('song_key_field').value
  let song_bars = document.getElementById('song_bars_field').value

  console.log(`Updating song_id: ${song_id}`)
  let url = `/api/song/${song_id}`
  let song_data = {
    id: song_id,
    title: song_title,
    composer: song_composer,
    key: song_key,
    bars: song_bars
  }

  let xhr = new XMLHttpRequest()
  xhr.onreadystatechange = () => {
    if (xhr.readyState == 4 && xhr.status == 200) {
      let response = JSON.parse(xhr.responseText)
      /*response is expected to be object like:
     {"status": "SUCCESS"}
    */
      console.log(`Status: ${response.status}`)
    }
  }
  //send HTTP POST message with JSON data
  xhr.open('POST', url, true)
  xhr.setRequestHeader("Content-Type", "application/json")
  xhr.send(JSON.stringify(song_data)) //send JSON data to server
}

function songSelectHandler(song_id) {
  // =================================
  let songDetailsDiv = document.getElementById('song_details')
  songDetailsDiv.innerHTML = ''
  let url = `/api/song/${song_id}`

  let xhr = new XMLHttpRequest()
  xhr.onreadystatechange = () => {
    if (xhr.readyState == 4 && xhr.status == 200) {
      let response = JSON.parse(xhr.responseText)
      /*response is expected to be object like:
      {
      "id": 372,
      "title": "Girl From Ipanema, The",
      "composer": "Jobim Antonio-Carlos",
      "key": "F",
      "bars": "[4/4][A]|:  F^7  |  %  |  G7#11  |  %  |  G-7  |]"
      }
      */
      //build and populate song details text input fields
      songDetailsDiv.innerHTML += `<h3><hr>Song Details</h3>`
      songDetailsDiv.innerHTML += `<div class="details_wrapper">`
      songDetailsDiv.innerHTML += `<div class="input_lable">ID: <input readonly class="details" type="text"  id="song_id_field" value="${response.id}"/></div>`
      songDetailsDiv.innerHTML += `</div>`
      songDetailsDiv.innerHTML += `<div class="details_wrapper">`
      songDetailsDiv.innerHTML += `<div class="input_lable">TITLE: <input class="details" type="text" id="song_title_field" value="${response.title}"/></div>`
      songDetailsDiv.innerHTML += `</div>`
      songDetailsDiv.innerHTML += `<div class="details_wrapper">`
      songDetailsDiv.innerHTML += `<div class="input_lable">COMPOSER: <input class="details" type="text" id="song_composer_field" value="${response.composer}"/></div>`
      songDetailsDiv.innerHTML += `</div>`
      songDetailsDiv.innerHTML += `<div class="details_wrapper">`
      songDetailsDiv.innerHTML += `<div class="input_lable">KEY: <input class="details" type="text" id="song_key_field" value="${response.key}"/></div>`
      songDetailsDiv.innerHTML += `</div>`
      songDetailsDiv.innerHTML += `<div class="details_wrapper">`
      songDetailsDiv.innerHTML += `<div>BARS: </div>`
      songDetailsDiv.innerHTML += `</div>`
      songDetailsDiv.innerHTML += `<div><textarea rows="6" cols="100" id="song_bars_field">${response.bars}</textarea></div>`
      songDetailsDiv.innerHTML += `<div></div>`
      songDetailsDiv.innerHTML += `<button id="song_update" onclick="songUpdateHandler()" >Update</button>`
    }
  }
  xhr.open('GET', url, true)
  xhr.send()
}

function titleSearchHandler() {
  //===============================

  let title = document.getElementById('title').value.trim()
  document.getElementById('title').value = title //replace with trimmed value
  let url = `/api/songs?title=${title}`
  if (title === '') {
    url = `/api/songs`
  }

  let songDiv = document.getElementById('song_data')
  songDiv.innerHTML = ''
  //clear song details div
  let songDetailsDiv = document.getElementById('song_details')
  songDetailsDiv.innerHTML = ''


  let xhr = new XMLHttpRequest()
  xhr.onreadystatechange = () => {
    if (xhr.readyState == 4 && xhr.status == 200) {
      let response = JSON.parse(xhr.responseText)
      //response is expected to object like: {songs: [ {id: title:},{id: title:},...]}
      songDiv.innerHTML = songDiv.innerHTML + `<h3><hr>Songs matching: ${title} </h3><ul>`
      for (let song of response.songs) {
        songDiv.innerHTML = songDiv.innerHTML + `<li onclick="songSelectHandler(${song.id})">
<font color="blue">${song.id}:  ${song.title}</font></li>`
      }
      songDiv.innerHTML = songDiv.innerHTML + `</ul>`
    }
  }
  xhr.open('GET', url, true)
  xhr.send()
}

//Attach Enter-key Handler for search field
const ENTER = 13 //Enter key character code
document.getElementById("title")
  .addEventListener("keyup", function(event) {
    event.preventDefault()
    if (event.keyCode === ENTER) {
      document.getElementById("search").click()
    }
  })
