const MOCK_API_URL = 'https://69b12ec1adac80b427c44154.mockapi.io/places';

window.onload = function() {
    getPlaces();
}

function getPlaces() {
    fetch(MOCK_API_URL)
        .then(res => res.json())
        .then(data => renderCards(data))
        .catch(error => console.error("에러:", error));
}

// 등록
function register() {
    const name = document.getElementById('name').value;
    const category = document.getElementById('category').value || "미분류";
    const address = document.getElementById('address').value;
    const call = document.getElementById('call').value || "전화번호 없음";
    const rating = document.getElementById('rating').value;

    if (!name || !address) {
        alert("이름과 주소는 꼭 입력해주세요!");
        return;
    }

    fetch(MOCK_API_URL, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            name,
            category,
            address,
            call,
            rating: parseInt(rating)
        })
    })
        .then(() => {
            alert("등록 완료! ✨");
            document.getElementById('name').value = '';
            document.getElementById('category').value = '';
            document.getElementById('address').value = '';
            document.getElementById('call').value = '';
            document.getElementById('rating').value = '5';
            getPlaces();
        });
}

// 수정 팝업
function editPlace(id, name, category, address, call, rating) {
    document.getElementById('modal-id').value = id;
    document.getElementById('modal-name').value = name;
    document.getElementById('modal-category').value = category;
    document.getElementById('modal-address').value = address;
    document.getElementById('modal-call').value = call;
    document.getElementById('modal-rating').value = rating;

    document.getElementById('editModal').style.display = 'block';
}

function closeModal() {
    document.getElementById('editModal').style.display = 'none';
}

// 수정 완료
function saveEdit() {
    const id = document.getElementById('modal-id').value;
    const name = document.getElementById('modal-name').value;
    const category = document.getElementById('modal-category').value;
    const address = document.getElementById('modal-address').value;
    const call = document.getElementById('modal-call').value;
    const rating = document.getElementById('modal-rating').value;

    fetch(`${MOCK_API_URL}/${id}`, {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            name,
            category,
            address,
            call,
            rating: parseInt(rating)
        })
    })
        .then(() => {
            alert("수정 완료되었습니다!");
            closeModal();
            getPlaces();
        });
}

function deletePlace(id) {
    if (!confirm("정말 삭제할까요?")) return;
    fetch(`${MOCK_API_URL}/${id}`, { method: 'DELETE' })
        .then(() => {
            alert("삭제 완료");
            getPlaces();
        });
}

function renderCards(places) {
    const container = document.getElementById('restaurant-list');
    container.innerHTML = '';

    places.forEach(place => {
        const ratingNum = parseInt(place.rating) || 0;
        const stars = '★'.repeat(ratingNum) + '☆'.repeat(5 - ratingNum);

        const pName = place.name || "이름 없음";
        const pCategory = place.category || "미분류";
        const pAddress = place.address || "주소 정보 없음";
        const pCall = place.call || "전화번호 없음";

        const cardHTML = `
        <div class="card">
            <div class="card-body">
                <h3>${pName}</h3>
                <p><b>분류:</b> ${pCategory}</p>
                <p><b>주소:</b> ${pAddress}</p>
                <p><b>번호:</b> ${pCall}</p>
                <p style="color: #ffc107; font-size: 1.2rem;">${stars}</p> 
                <div style="margin-top: 15px;">
                    <button onclick="editPlace('${place.id}', '${pName.replace(/'/g, "\\'")}', '${pCategory.replace(/'/g, "\\'")}', '${pAddress.replace(/'/g, "\\'")}', '${pCall.replace(/'/g, "\\'")}', '${ratingNum}')">수정</button>
                    <button onclick="deletePlace('${place.id}')">삭제</button>
                </div>
            </div>
        </div>`;
        container.insertAdjacentHTML('beforeend', cardHTML);
    });
}