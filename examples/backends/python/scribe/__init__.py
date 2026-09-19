"""Scribe — the Python backend for the Meteroid SDK demo.

Implements every operation of ``examples/openapi.yaml`` on top of the ``meteroid``
package. Read the handlers in ``scribe/routes/``; each one is written so that the
Meteroid SDK call is the line worth reading, and everything around it is framing.

Start here:

- ``routes/transcriptions.py`` — the metered action: check the entitlement, then report
  the consumption. This is what the demo exists to show.
- ``entitlements.py`` — normalizing Meteroid's three-way entitlement union.
- ``catalog.py`` — resolving a catalog the demo never creates.
- ``routes/webhooks.py`` — verifying a Standard Webhooks signature over raw bytes.
"""
