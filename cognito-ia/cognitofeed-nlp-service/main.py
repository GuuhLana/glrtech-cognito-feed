from fastapi import FastAPI
from models.request_response import EntryText, AnswerAnalysis
from services.summarizer import summary_generator
from services.sentiment import analyze_feeling

app = FastAPI()

@app.post("/analyze", response_model=AnswerAnalysis)
def text_analyzer(entry: EntryText):
    summary = summary_generator(entry.text)
    feeling, confidence = analyze_feeling(entry.text)
    return AnswerAnalysis(
        summary=summary,
        sentiment=feeling,
        confidence=confidence
    )
