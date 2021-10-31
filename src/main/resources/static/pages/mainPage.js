//import {clearElement} from "../util/util.js";
import {createNewDocumentForm} from "../components/newDocumentForm.js";


export const main = document.getElementById('main');

(async () => { await printFirstPage() })()

export async function printFirstPage() {
    createNewDocumentForm()
}