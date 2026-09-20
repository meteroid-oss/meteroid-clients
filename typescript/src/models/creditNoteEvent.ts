// this file is @generated
import { parseDateTime } from "../datetime";
import {
  type CreditNoteEventData,
  CreditNoteEventDataSerializer,
} from "./creditNoteEventData";
import { type EventId, EventIdSerializer } from "./eventId";
import { type EventType, EventTypeSerializer } from "./eventType";

export interface CreditNoteEvent {
  flattenCreditnoteeventdata: CreditNoteEventData;

  id: EventId;

  timestamp: Date;

  type: EventType;
}

export const CreditNoteEventSerializer = {
  _fromJsonObject(object: any): CreditNoteEvent {
    return {
      flattenCreditnoteeventdata: CreditNoteEventDataSerializer._fromJsonObject(
        object["__flatten_creditnoteeventdata"]
      ),
      id: EventIdSerializer._fromJsonObject(object["id"]),
      timestamp: parseDateTime(object["timestamp"]),
      type: EventTypeSerializer._fromJsonObject(object["type"]),
    };
  },

  _toJsonObject(self: CreditNoteEvent): any {
    return {
      __flatten_creditnoteeventdata: CreditNoteEventDataSerializer._toJsonObject(
        self.flattenCreditnoteeventdata
      ),
      id: EventIdSerializer._toJsonObject(self.id),
      timestamp: self.timestamp,
      type: EventTypeSerializer._toJsonObject(self.type),
    };
  },
};
