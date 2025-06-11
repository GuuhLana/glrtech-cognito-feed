from pydantic import BaseModel

class EntryText(BaseModel):
    text: str

class AnswerAnalysis(BaseModel):
    summary: str
    sentiment: str
    confidence: float
