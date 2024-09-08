console.log('check');

const searchBtn = document.getElementById('searchBtn');

const searchResult = document.getElementById("searchResult");

const clearBtn = document.getElementById("clearBtn");

const moreBtn = document.getElementById("more");

var pageNum = 1;

let isLoading = false;

const loadingElement = document.getElementById('isLoading');

searchBtn.addEventListener('click', () => {
  const sp = /\s/;
  const re = /\s+/;
  const tagNames = document.forms.searchForm.searchBox.value.split(re);
  var url = `https://qiita.com/api/v2/items?page=${pageNum}&per_page=20&query=`;
  for (let tag of tagNames) {
    const append = `+tag%3A${tag}`;
    url += append;
  }

  fetchData(url);
  moreBtn.style.display = 'block';
})

function show(data) {
  console.log(data);
  for (let i = 0; i < 20; i++) {
    console.log(data[i].url);
    console.log(data[i].title);
    const li = document.createElement('li');
    li.innerHTML = `<a href=${data[i].url}>${data[i].title}</a>`
    searchResult.appendChild(li);
  }
}

clearBtn.addEventListener('click', () => {
  searchResult.innerHTML = "";
  document.forms.searchForm.searchBox.value = "";
  moreBtn.style.display = 'none';
})

moreBtn.addEventListener('click', () => {
  const tagName = document.forms.searchForm.searchBox.value;
  pageNum++;
  const url = `https://qiita.com/api/v2/items?page=${pageNum}&per_page=20&query=tag:${tagName}`;
  fetch(url)
    .then(response => response.json())
    .then(data => show(data))
    .catch(error => console.error('Fetch error', error));
})


function artificialDelay(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

async function fetchData(url) {
  isLoading = true;
  updateLoadingState();

  try {
    await artificialDelay(2000);
    const response = await fetch(url);
    const data = await response.json();

    show(data);
  } catch (error) {
    console.error('Error fetching data:', error);
  } finally {
    isLoading = false;
    updateLoadingState();
  }
}

function updateLoadingState() {
  if (isLoading) {
    loadingElement.style.display = 'block';
  } else {
    loadingElement.style.display = 'none';
  }
}