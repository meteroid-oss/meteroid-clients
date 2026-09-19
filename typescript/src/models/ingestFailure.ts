// this file is @generated

export interface IngestFailure {
  eventId: string;

  reason: string;
}

export const IngestFailureSerializer = {
  _fromJsonObject(object: any): IngestFailure {
    return {
      eventId: object["event_id"],
      reason: object["reason"],
    };
  },

  _toJsonObject(self: IngestFailure): any {
    return {
      event_id: self.eventId,
      reason: self.reason,
    };
  },
};
