/*- fruits という「name, price」を持っている object の配列を作成
- fruits には下記を代入する
  - name: りんご, price: 100
  - name: バナナ, price: 500
  - name: レモン, price: 950
- 税込みの計算をする
- ループ（繰り返し処理）して、「〇〇は税込み XX 円です。」と表示する
- 税込み価格が 1000 円を超えたら、「〇〇は高いので買うのをやめます。」と表示する
- 消費税は 8%とする*/

const fruits = [];
class fruit {
  constructor(name, price) {
    this.name = name;
    this.price = price;
  };
};

const apple = new fruit("りんご", 100);
const banana = new fruit("バナナ", 500);
const lemon = new fruit("レモン", 950);

fruits.push(apple);
fruits.push(banana);
fruits.push(lemon);

for (let i = 0; i < fruits.length; i++) {
  const name = fruits[i].name;
  const price = fruits[i].price;
  const price_include_tax = price * 1.08;
  console.log(name + `は` + price_include_tax + '円です。');
  if (price_include_tax > 1000) {
    console.log(`${name}は高いので買うのをやめます。`);
  };
};

// // 練習問題
// // ## 練習 2

// // - vegetables という「name, price」を持っている object の配列を作成
// // - vegetables には下記を代入する
// //   - name: 人参, price: 300
// //   - name: キャベツ, price: 750
// //   - name: じゃがいも, price: 980
// // - ループ（繰り返し処理）して、「〇〇は税込み XX 円です。」と表示する
// // - 税込み価格が 1000 円を超えたら、「〇〇は高いので買うのをやめます。」と表示する
// // - fruits からコピーできるところはコピーして OK
// // - 作成できたら共通している処理を関数化する


const vegetables = [{ name: `人参`, price: 300 }, { name: `キャベツ`, price: 750 }, { name: `じゃがいも`, price: 980 }];

for (let i = 0; i < vegetables.length; i++) {
  const name = vegetables[i].name;
  const price = vegetables[i].price;
  const price_include_tax = price * 1.08;
  console.log(name + `は` + price_include_tax + '円です。');
  if (price_include_tax > 1000) {
    console.log(`${name}は高いので買うのをやめます。`);
  };
};

function SayTaxedPrices(arr) {
  if (Array.isArray(arr) !== true) {
    throw new Error("You must assign array to this function");
  } else {
    for (let i = 0; i < arr.length; i++) {
      const name = arr[i].name;
      const price = arr[i].price;
      const price_include_tax = price * 1.08;
      console.log(name + `は` + price_include_tax + '円です。');
      if (price_include_tax > 1000) {
        console.log(`${name}は高いので買うのをやめます。`);
      };
    };
  };

};

SayTaxedPrices(vegetables);
SayTaxedPrices(fruits);


// ## 練習 3

// - name と price を入力できるフォームを作成する
//   - form の名前を product にする
//   - 入力フォームの名前を productName と productPrice にする
// - 「買い物」ボタンを作成する
// - 買い物ボタンを押したら、productPrice から税込み価格を計算して「〇〇は税込み XX 円です。」と表示する
// - 税込み価格が 1000 円を超えたら、「〇〇は高いので買うのをやめます。」と表示する


function GetTaxedPrice(price) {
  return price * 1.08;
};

function JudgePrice(price) {
  if (price > 1000) {
    return true;
  } else {
    return false;
  }
};

const btn = document.getElementById(`buyButton`);
const judgement = document.getElementById("judgement");


btn.addEventListener(`click`, () => {
  const productPrice = document.forms.product.productPrice.value;
  const productName = document.forms.product.productName.value;
  const regex = /[0-9]+/

  if (productPrice === "") {
    const alert2 = document.getElementById("alert2");
    alert2.textContent = "価格が入力されていません";
  } else if (!regex.test(productPrice)) {
    alert2.textContent = "";
    throw new Error("数字ではありません");
  } else {
    alert2.textContent = "";
  }

  if (productName === "") {
    const alert1 = document.getElementById("alert1");
    alert1.textContent = "商品名が入力されていません";
  } else {
    alert1.textContent = "";
  };

  if (productName != "" && regex.test(productPrice)) {
    const taxed_price = GetTaxedPrice(productPrice);
    judgement.textContent = productName + 'は税込み' + taxed_price + "円です";
    if (JudgePrice(taxed_price)) {
      judgement.innerHTML += `<br>${productName}は高いので買うのをやめます。`;
    };
  } else {
    judgement.textContent = "";
  }









});

const nameForm = document.getElementById('productName');


