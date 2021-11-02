export function getDocumentNumber(id) {
    const num = document.createElement('span')
    const numb = document.createElement('b')
    const numSpan = document.createElement('span')
    numb.innerText = "Номер документа: "
    numSpan.innerText = id
    num.append(numb)
    num.append(numSpan)
    num.append(document.createElement("br"))
    return num;
}

export function getDocumentName(docName) {
    const name = document.createElement('span')
    const nameb = document.createElement('b')
    const nameSpan = document.createElement('span')
    nameb.innerText = "Название документа: "
    nameSpan.innerText = docName
    name.append(nameb)
    name.append(nameSpan)
    name.append(document.createElement("br"))
    return name;
}

export function getDocumentSaveTime(docSaveTime) {
    const saveTime = document.createElement('span')
    const saveTimeb = document.createElement('b')
    const saveTimeSpan = document.createElement('span')
    saveTimeb.innerText = "Дата формирования документа: "
    saveTimeSpan.innerText = docSaveTime
    saveTime.append(saveTimeb)
    saveTime.append(saveTimeSpan)
    saveTime.append(document.createElement("br"))
    return saveTime;
}

export function getDocumentCodes(codes) {
    const codesEl = document.createElement('span')
    const codesb = document.createElement('b')
    const codesSpan = document.createElement('span')
    let codesStr = ""
    for (let j = 0; j < codes.length; j++) {
        if (j !== 0) {
            codesStr = codesStr + ", "
        }
        codesStr = codesStr + codes[j]
    }
    codesb.innerText = "Коды документа: "
    codesSpan.innerText = codesStr
    codesEl.append(codesb)
    codesEl.append(codesSpan)
    codesEl.append(document.createElement("br"))
    return codesEl
}

export function getDocumentText(documentText) {
    const textEl = document.createElement('div')
    const textB = document.createElement('b')
    const textDiv = document.createElement('div')
    textB.innerText = "Текст документа: "
    textDiv.innerText = documentText
    textEl.append(textB)
    textEl.append(document.createElement("br"))
    textEl.append(textDiv)
    return textEl;
}