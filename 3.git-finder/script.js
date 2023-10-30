const searchInput = document.getElementById("search");
const searchBtn = document.getElementById("search-btn");
const userImg = document.querySelector("img");

async function getUserInfo(userName) {
  try {
      const res = await fetch(
        // "https://api.github.com/repos/octocat/Spoon-Knife/issues",
        `https://api.github.com/users/${userName}`,
        {
          headers: {
            Authorization: `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`,
          },
        })
      const jsonResponse1 = await res.json()
      showUserInfo(jsonResponse1)
  } catch (error) {
      console.log(error)
  } finally {
      console.log('finally')
  }
}

function addEventListener() {
  // searchInput.addEventListener('keydown', (e) => {
  //   // getUserInfo(e.target.value);
  //   console.log(e.target.value);
  // })

  searchBtn.addEventListener('click', () => {
    getUserInfo(searchInput.value);
  })
}

addEventListener();

function showUserInfo(user) {
  userImg.src = user.avatar_url;
  
}
